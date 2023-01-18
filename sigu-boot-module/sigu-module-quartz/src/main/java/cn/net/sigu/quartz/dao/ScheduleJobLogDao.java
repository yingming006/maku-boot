package cn.net.sigu.quartz.dao;

import cn.net.sigu.framework.common.dao.BaseDao;
import cn.net.sigu.quartz.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 定时任务日志
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}