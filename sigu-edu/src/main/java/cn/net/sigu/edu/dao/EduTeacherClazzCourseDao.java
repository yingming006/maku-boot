package cn.net.sigu.edu.dao;

import cn.net.sigu.edu.entity.EduTeacherClazzCourseEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
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
