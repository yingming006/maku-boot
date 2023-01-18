package cn.net.sigu.edu.dao;

import cn.net.sigu.edu.entity.EduSemesterEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
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
