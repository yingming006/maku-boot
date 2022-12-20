package net.maku.edu.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.edu.entity.EduTeacherEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 教师信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduTeacherDao extends BaseDao<EduTeacherEntity> {

}
