package cn.net.sigu.system.controller;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.utils.Result;
import cn.net.sigu.system.query.SysLogLoginQuery;
import cn.net.sigu.system.service.SysLogLoginService;
import cn.net.sigu.system.vo.SysLogLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录日志
 *
 * @author 阿沐 babamu@126.com
 */
@RestController
@RequestMapping("sys/log/login")
@Tag(name = "登录日志")
@AllArgsConstructor
public class SysLogLoginController {
    private final SysLogLoginService sysLogLoginService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:log:login')")
    public Result<PageResult<SysLogLoginVO>> page(@Valid SysLogLoginQuery query) {
        PageResult<SysLogLoginVO> page = sysLogLoginService.page(query);

        return Result.ok(page);
    }

    @GetMapping("export")
    @Operation(summary = "导出excel")
    @PreAuthorize("hasAuthority('sys:log:login')")
    public void export() {
        sysLogLoginService.export();
    }

}