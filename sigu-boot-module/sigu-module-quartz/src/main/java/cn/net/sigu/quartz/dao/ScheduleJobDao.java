package cn.net.sigu.quartz.dao;

import cn.net.sigu.framework.common.dao.BaseDao;
import cn.net.sigu.quartz.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 定时任务
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
}