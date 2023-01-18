package cn.net.sigu.quartz.controller;

import cn.net.sigu.quartz.query.ScheduleJobLogQuery;
import cn.net.sigu.quartz.vo.ScheduleJobLogVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.utils.Result;
import cn.net.sigu.quartz.convert.ScheduleJobLogConvert;
import cn.net.sigu.quartz.entity.ScheduleJobLogEntity;
import cn.net.sigu.quartz.service.ScheduleJobLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
* 定时任务日志
*
* @author 阿沐 babamu@126.com
*/
@RestController
@RequestMapping("schedule/log")
@Tag(name="定时任务日志")
@AllArgsConstructor
public class ScheduleJobLogController {
    private final ScheduleJobLogService scheduleJobLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('schedule:log')")
    public Result<PageResult<ScheduleJobLogVO>> page(@Valid ScheduleJobLogQuery query){
        PageResult<ScheduleJobLogVO> page = scheduleJobLogService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('schedule:log')")
    public Result<ScheduleJobLogVO> get(@PathVariable("id") Long id){
        ScheduleJobLogEntity entity = scheduleJobLogService.getById(id);

        return Result.ok(ScheduleJobLogConvert.INSTANCE.convert(entity));
    }

}