package cn.net.sigu.system.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.net.sigu.framework.common.exception.ServerException;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import cn.net.sigu.system.convert.SysDictTypeConvert;
import cn.net.sigu.system.dao.SysDictDataDao;
import cn.net.sigu.system.dao.SysDictTypeDao;
import cn.net.sigu.system.entity.SysDictDataEntity;
import cn.net.sigu.system.entity.SysDictTypeEntity;
import cn.net.sigu.system.enums.DictSourceEnum;
import cn.net.sigu.system.query.SysDictTypeQuery;
import cn.net.sigu.system.service.SysDictTypeService;
import cn.net.sigu.system.vo.SysDictTypeVO;
import cn.net.sigu.system.vo.SysDictVO;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fhs.trans.service.impl.DictionaryTransService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 字典类型
 *
 * @author 阿沐 babamu@126.com
 */
@Service
@AllArgsConstructor
public class SysDictTypeServiceImpl extends BaseServiceImpl<SysDictTypeDao, SysDictTypeEntity> implements SysDictTypeService, InitializingBean {
    private final SysDictDataDao sysDictDataDao;

    private final SysDictTypeDao sysDictTypeDao;
    private final DictionaryTransService dictionaryTransService;

    @Override
    public PageResult<SysDictTypeVO> page(SysDictTypeQuery query) {
        IPage<SysDictTypeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(SysDictTypeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private Wrapper<SysDictTypeEntity> getWrapper(SysDictTypeQuery query) {
        LambdaQueryWrapper<SysDictTypeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getDictType()), SysDictTypeEntity::getDictType, query.getDictType());
        wrapper.like(StrUtil.isNotBlank(query.getDictName()), SysDictTypeEntity::getDictName, query.getDictName());
        wrapper.orderByAsc(SysDictTypeEntity::getSort);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDictTypeVO vo) {
        SysDictTypeEntity entity = SysDictTypeConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictTypeVO vo) {
        SysDictTypeEntity entity = SysDictTypeConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public List<SysDictVO.DictData> getDictSql(Long id) {
        SysDictTypeEntity entity = this.getById(id);
        try {
            return sysDictDataDao.getListForSql(entity.getDictSql());
        } catch (Exception e) {
            throw new ServerException("动态SQL执行失败，请检查SQL是否正确！");
        }
    }

    @Override
    public List<SysDictVO> getDictList() {
        // 全部字典类型列表
        List<SysDictTypeEntity> typeList = this.list(Wrappers.emptyWrapper());

        // 全部字典数据列表
        QueryWrapper<SysDictDataEntity> query = new QueryWrapper<SysDictDataEntity>().orderByAsc("sort");
        List<SysDictDataEntity> dataList = sysDictDataDao.selectList(query);

        // 全部字典列表
        List<SysDictVO> dictList = new ArrayList<>(typeList.size());
        for (SysDictTypeEntity type : typeList) {
            SysDictVO dict = new SysDictVO();
            dict.setDictType(type.getDictType());

            for (SysDictDataEntity data : dataList) {
                if (type.getId().equals(data.getDictTypeId())) {
                    dict.getDataList().add(new SysDictVO.DictData(data.getDictLabel(), data.getDictValue(), data.getLabelClass()));
                }
            }

            // 数据来源动态SQL
            if (type.getDictSource() == DictSourceEnum.SQL.getValue()) {
                // 增加动态列表
                String sql = type.getDictSql();
                try {
                    dict.setDataList(sysDictDataDao.getListForSql(sql));
                } catch (Exception e) {
                    log.error("增加动态字典异常: type=" + type, e);
                }
            }

            dictList.add(dict);
        }

        return dictList;
    }

    @Override
    public void afterPropertiesSet() {
        refreshTransCache();
    }

    public void refreshTransCache() {
        // 异步不阻塞主线程，不会 增加启动用时
        CompletableFuture.supplyAsync(() -> {
            // 获取所有的字典项数据
            List<SysDictDataEntity> dataList = sysDictDataDao.selectList(new LambdaQueryWrapper<>());
            // 获取所有动态 sql 字典数据
            List<SysDictTypeEntity> dictTypeEntities = super.list();
            for (SysDictTypeEntity dictTypeEntity : dictTypeEntities) {
                if (1 == dictTypeEntity.getDictSource()) {
                    List<SysDictDataEntity> list = sysDictDataDao.getListByDynamicSQL(dictTypeEntity.getDictSql());
                    list.forEach(data -> data.setDictTypeId(dictTypeEntity.getId()));
                    dataList.addAll(list);
                }
            }
            // 根据类型分组
            Map<Long, List<SysDictDataEntity>> dictTypeDataMap = dataList.stream().collect(Collectors
                    .groupingBy(SysDictDataEntity::getDictTypeId));

            for (SysDictTypeEntity dictTypeEntity : dictTypeEntities) {
                if (dictTypeDataMap.containsKey(dictTypeEntity.getId())) {
                    dictionaryTransService.refreshCache(dictTypeEntity.getDictType(), dictTypeDataMap.get(dictTypeEntity.getId())
                            .stream().collect(Collectors.toMap(SysDictDataEntity::getDictValue, SysDictDataEntity::getDictLabel)));
                }
            }
            return null;
        });
    }
}
