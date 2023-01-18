package cn.net.sigu.edu.controller;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduSemesterConvert;
import cn.net.sigu.edu.entity.EduSemesterEntity;
import cn.net.sigu.edu.service.EduSemesterService;
import cn.net.sigu.edu.query.EduSemesterQuery;
import cn.net.sigu.edu.vo.EduSemesterVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 学期信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-19
*/
@RestController
@RequestMapping("edu/semester")
@Tag(name="学期信息表")
@AllArgsConstructor
public class EduSemesterController {
    private final EduSemesterService eduSemesterService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:semester:page')")
    public Result<PageResult<EduSemesterVO>> page(@Valid EduSemesterQuery query){
        PageResult<EduSemesterVO> page = eduSemesterService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:semester:info')")
    public Result<EduSemesterVO> get(@PathVariable("id") Long id){
        EduSemesterEntity entity = eduSemesterService.getById(id);

        return Result.ok(EduSemesterConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:semester:save')")
    public Result<String> save(@RequestBody EduSemesterVO vo){
        eduSemesterService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:semester:update')")
    public Result<String> update(@RequestBody @Valid EduSemesterVO vo){
        eduSemesterService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:semester:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduSemesterService.delete(idList);

        return Result.ok();
    }
}
