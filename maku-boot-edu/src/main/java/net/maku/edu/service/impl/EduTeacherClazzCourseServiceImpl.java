package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduTeacherClazzCourseConvert;
import net.maku.edu.entity.EduTeacherClazzCourseEntity;
import net.maku.edu.query.EduTeacherClazzCourseQuery;
import net.maku.edu.vo.EduTeacherClazzCourseVO;
import net.maku.edu.dao.EduTeacherClazzCourseDao;
import net.maku.edu.service.EduTeacherClazzCourseService;
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
