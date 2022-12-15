package net.maku.education.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.education.convert.EduClazzConvert;
import net.maku.education.entity.EduClazzEntity;
import net.maku.education.query.EduClazzQuery;
import net.maku.education.service.EduClazzService;
import net.maku.education.vo.EduClazzVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.utils.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 班级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/clazz")
@Tag(name="班级信息表")
@AllArgsConstructor
public class EduClazzController {
    private final EduClazzService eduClazzService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:clazz:page')")
    public Result<PageResult<EduClazzVO>> page(@Valid EduClazzQuery query){
        PageResult<EduClazzVO> page = eduClazzService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:clazz:info')")
    public Result<EduClazzVO> get(@PathVariable("id") Long id){
        EduClazzEntity entity = eduClazzService.getById(id);

        return Result.ok(EduClazzConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:clazz:save')")
    public Result<String> save(@RequestBody EduClazzVO vo){
        eduClazzService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:clazz:update')")
    public Result<String> update(@RequestBody @Valid EduClazzVO vo){
        eduClazzService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:clazz:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduClazzService.delete(idList);

        return Result.ok();
    }
}
