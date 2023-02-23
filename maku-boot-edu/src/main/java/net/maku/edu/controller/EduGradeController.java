package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.edu.convert.EduGradeConvert;
import net.maku.edu.entity.EduGradeEntity;
import net.maku.edu.service.EduGradeService;
import net.maku.edu.query.EduGradeQuery;
import net.maku.edu.vo.EduGradeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 年级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-20
*/
@RestController
@RequestMapping("edu/grade")
@Tag(name="年级信息表")
@AllArgsConstructor
public class EduGradeController {

    @Autowired
    private EduGradeService eduGradeService;

    @Autowired
    private EduGradeConvert eduGradeConvert;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:grade:page')")
    public Result<PageResult<EduGradeVO>> page(@Valid EduGradeQuery query){
        PageResult<EduGradeVO> page = eduGradeService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:grade:info')")
    public Result<EduGradeVO> get(@PathVariable("id") Long id){
        EduGradeEntity entity = eduGradeService.getById(id);

        return Result.ok(eduGradeConvert.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:grade:save')")
    public Result<String> save(@RequestBody EduGradeVO vo){
        eduGradeService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:grade:update')")
    public Result<String> update(@RequestBody @Valid EduGradeVO vo){
        eduGradeService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:grade:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduGradeService.delete(idList);

        return Result.ok();
    }
}
