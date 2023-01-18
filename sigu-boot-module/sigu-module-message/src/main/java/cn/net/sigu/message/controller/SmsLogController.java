package cn.net.sigu.message.controller;

import cn.net.sigu.message.vo.SmsLogVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.utils.Result;
import cn.net.sigu.message.convert.SmsLogConvert;
import cn.net.sigu.message.entity.SmsLogEntity;
import cn.net.sigu.message.query.SmsLogQuery;
import cn.net.sigu.message.service.SmsLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
* 短信日志
*
* @author 阿沐 babamu@126.com
*/
@RestController
@RequestMapping("message/sms/log")
@Tag(name="短信日志")
@AllArgsConstructor
public class SmsLogController {
    private final SmsLogService smsLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sms:log')")
    public Result<PageResult<SmsLogVO>> page(@Valid SmsLogQuery query){
        PageResult<SmsLogVO> page = smsLogService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sms:log')")
    public Result<SmsLogVO> get(@PathVariable("id") Long id){
        SmsLogEntity entity = smsLogService.getById(id);

        return Result.ok(SmsLogConvert.INSTANCE.convert(entity));
    }

}