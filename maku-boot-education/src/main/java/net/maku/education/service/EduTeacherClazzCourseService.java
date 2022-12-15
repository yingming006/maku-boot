package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduTeacherClazzCourseVO;
import net.maku.education.query.EduTeacherClazzCourseQuery;
import net.maku.education.entity.EduTeacherClazzCourseEntity;

import java.util.List;

/**
 * 教师_班级_课程关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduTeacherClazzCourseService extends BaseService<EduTeacherClazzCourseEntity> {

    PageResult<EduTeacherClazzCourseVO> page(EduTeacherClazzCourseQuery query);

    void save(EduTeacherClazzCourseVO vo);

    void update(EduTeacherClazzCourseVO vo);

    void delete(List<Long> idList);
}
