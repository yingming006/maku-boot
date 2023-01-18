package cn.net.sigu.quartz.service;

import cn.net.sigu.quartz.query.ScheduleJobQuery;
import cn.net.sigu.quartz.vo.ScheduleJobVO;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.quartz.entity.ScheduleJobEntity;

import java.util.List;

/**
 * 定时任务
 *
 * @author 阿沐 babamu@126.com
 */
public interface ScheduleJobService extends BaseService<ScheduleJobEntity> {

    PageResult<ScheduleJobVO> page(ScheduleJobQuery query);

    void save(ScheduleJobVO vo);

    void update(ScheduleJobVO vo);

    void delete(List<Long> idList);

    void run(ScheduleJobVO vo);

    void changeStatus(ScheduleJobVO vo);
}