package net.maku.edu.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.edu.entity.EduTeacherClazzCourseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 教师_班级_课程关联表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduTeacherClazzCourseDao extends BaseDao<EduTeacherClazzCourseEntity> {

}
