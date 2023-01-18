package cn.net.sigu.quartz.service;

import cn.net.sigu.quartz.query.ScheduleJobLogQuery;
import cn.net.sigu.quartz.vo.ScheduleJobLogVO;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.quartz.entity.ScheduleJobLogEntity;

/**
 * 定时任务日志
 *
 * @author 阿沐 babamu@126.com
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

    PageResult<ScheduleJobLogVO> page(ScheduleJobLogQuery query);

}