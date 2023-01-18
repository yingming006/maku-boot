package cn.net.sigu.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduSemesterConvert;
import cn.net.sigu.edu.dao.EduSemesterDao;
import cn.net.sigu.edu.entity.EduSemesterEntity;
import cn.net.sigu.edu.query.EduSemesterQuery;
import cn.net.sigu.edu.service.EduSemesterService;
import cn.net.sigu.edu.vo.EduSemesterVO;
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
