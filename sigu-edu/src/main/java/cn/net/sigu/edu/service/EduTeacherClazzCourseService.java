package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduTeacherClazzCourseVO;
import cn.net.sigu.edu.query.EduTeacherClazzCourseQuery;
import cn.net.sigu.edu.entity.EduTeacherClazzCourseEntity;

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
