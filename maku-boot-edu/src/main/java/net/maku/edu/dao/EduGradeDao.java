package net.maku.edu.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.edu.entity.EduGradeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 年级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-20
*/
@Mapper
public interface EduGradeDao extends BaseDao<EduGradeEntity> {
	
}
