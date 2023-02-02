package net.maku.edu.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.edu.entity.EduSemesterEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 学期信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-19
*/
@Mapper
public interface EduSemesterDao extends BaseDao<EduSemesterEntity> {

}
