package net.maku.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduSemesterConvert;
import net.maku.edu.dao.EduSemesterDao;
import net.maku.edu.entity.EduSemesterEntity;
import net.maku.edu.query.EduSemesterQuery;
import net.maku.edu.service.EduSemesterService;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.edu.vo.EduSemesterVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学期信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-19
 */
@Service
@AllArgsConstructor
public class EduSemesterServiceImpl extends BaseServiceImpl<EduSemesterDao, EduSemesterEntity> implements EduSemesterService {

    @Override
    public PageResult<EduSemesterVO> page(EduSemesterQuery query) {
        IPage<EduSemesterEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduSemesterConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduSemesterEntity> getWrapper(EduSemesterQuery query){
        LambdaQueryWrapper<EduSemesterEntity> wrapper = Wrappers.lambdaQuery();
        if (StrUtil.isBlank(query.getOrder())) {
            wrapper.orderByDesc(EduSemesterEntity::getStartDate);
        }
        return wrapper;
    }

    @Override
    public void save(EduSemesterVO vo) {
        EduSemesterEntity entity = EduSemesterConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduSemesterVO vo) {
        EduSemesterEntity entity = EduSemesterConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
