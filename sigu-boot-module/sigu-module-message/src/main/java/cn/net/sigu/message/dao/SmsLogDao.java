package cn.net.sigu.message.dao;

import cn.net.sigu.framework.common.dao.BaseDao;
import cn.net.sigu.message.entity.SmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信日志
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface SmsLogDao extends BaseDao<SmsLogEntity> {
	
}