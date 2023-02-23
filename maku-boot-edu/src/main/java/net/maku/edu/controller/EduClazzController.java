package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduClazzConvert;
import net.maku.edu.entity.EduClazzEntity;
import net.maku.edu.query.EduClazzQuery;
import net.maku.edu.service.EduClazzService;
import net.maku.edu.vo.EduClazzVO;
import net.maku.edu.vo.SysDictVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private EduClazzService eduClazzService;

    @Autowired
    private EduClazzConvert eduClazzConvert;

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
        return Result.ok(eduClazzConvert.convert(entity));
    }

    @GetMapping("/{id}/detail")
    @Operation(summary = "班级信息，包括开设课程")
    @PreAuthorize("hasAuthority('edu:clazz:info')")
    public Result<EduClazzVO> detail(@PathVariable("id") Long id){
        EduClazzVO vo = eduClazzService.detail(id);
        return Result.ok(vo);
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

    @GetMapping("/dict")
    @Operation(summary = "字典查询")
    @PreAuthorize("hasAuthority('edu:clazz:page')")
    public Result<PageResult<SysDictVO.DictData>> dict(@Valid EduClazzQuery query) {
        List<SysDictVO.DictData> list = eduClazzService.getDictData(query);

        PageResult<SysDictVO.DictData> page = new PageResult<>(list, list.size());
        return Result.ok(page);
    }
}
