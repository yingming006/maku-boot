package net.maku.edu.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.edu.entity.EduCourseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 课程信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduCourseDao extends BaseDao<EduCourseEntity> {

}
