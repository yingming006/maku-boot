package net.maku.edu.service;

import net.maku.edu.entity.EduClazzCourseTeacherEntity;
import net.maku.edu.query.EduClazzCourseTeacherQuery;
import net.maku.edu.vo.EduClazzCourseTeacherVO;
import net.maku.framework.mybatis.service.BaseService;

import java.util.List;

/**
 * 班级课程关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-2-15
 */
public interface EduClazzCourseTeacherService extends BaseService<EduClazzCourseTeacherEntity> {

    List<EduClazzCourseTeacherVO> list(EduClazzCourseTeacherQuery query);
}
