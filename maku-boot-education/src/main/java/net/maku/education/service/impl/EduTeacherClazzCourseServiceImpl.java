package net.maku.education.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.education.convert.EduTeacherClazzCourseConvert;
import net.maku.education.entity.EduTeacherClazzCourseEntity;
import net.maku.education.query.EduTeacherClazzCourseQuery;
import net.maku.education.vo.EduTeacherClazzCourseVO;
import net.maku.education.dao.EduTeacherClazzCourseDao;
import net.maku.education.service.EduTeacherClazzCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 教师_班级_课程关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduTeacherClazzCourseServiceImpl extends BaseServiceImpl<EduTeacherClazzCourseDao, EduTeacherClazzCourseEntity> implements EduTeacherClazzCourseService {

    @Override
    public PageResult<EduTeacherClazzCourseVO> page(EduTeacherClazzCourseQuery query) {
        IPage<EduTeacherClazzCourseEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduTeacherClazzCourseConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduTeacherClazzCourseEntity> getWrapper(EduTeacherClazzCourseQuery query){
        LambdaQueryWrapper<EduTeacherClazzCourseEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduTeacherClazzCourseVO vo) {
        EduTeacherClazzCourseEntity entity = EduTeacherClazzCourseConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduTeacherClazzCourseVO vo) {
        EduTeacherClazzCourseEntity entity = EduTeacherClazzCourseConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
