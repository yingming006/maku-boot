package net.maku.education.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.education.convert.EduStudentConvert;
import net.maku.education.entity.EduStudentEntity;
import net.maku.education.query.EduStudentQuery;
import net.maku.education.vo.EduStudentVO;
import net.maku.education.dao.EduStudentDao;
import net.maku.education.service.EduStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduStudentServiceImpl extends BaseServiceImpl<EduStudentDao, EduStudentEntity> implements EduStudentService {

    @Override
    public PageResult<EduStudentVO> page(EduStudentQuery query) {
        IPage<EduStudentEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduStudentConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduStudentEntity> getWrapper(EduStudentQuery query){
        LambdaQueryWrapper<EduStudentEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduStudentVO vo) {
        EduStudentEntity entity = EduStudentConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduStudentVO vo) {
        EduStudentEntity entity = EduStudentConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
