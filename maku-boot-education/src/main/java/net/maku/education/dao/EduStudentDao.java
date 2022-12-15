package net.maku.education.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.education.entity.EduStudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 学生信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduStudentDao extends BaseDao<EduStudentEntity> {

}
