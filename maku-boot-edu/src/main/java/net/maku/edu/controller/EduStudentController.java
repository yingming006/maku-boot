package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.edu.convert.EduStudentConvert;
import net.maku.edu.entity.EduStudentEntity;
import net.maku.edu.service.EduStudentService;
import net.maku.edu.query.EduStudentQuery;
import net.maku.edu.vo.EduStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 学生信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/student")
@Tag(name="学生信息表")
@AllArgsConstructor
public class EduStudentController {

    @Autowired
    private EduStudentService eduStudentService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:student:page')")
    public Result<PageResult<EduStudentVO>> page(@Valid EduStudentQuery query){
        PageResult<EduStudentVO> page = eduStudentService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:student:info')")
    public Result<EduStudentVO> get(@PathVariable("id") Long id){
        EduStudentEntity entity = eduStudentService.getById(id);

        return Result.ok(EduStudentConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:student:save')")
    public Result<String> save(@RequestBody EduStudentVO vo){
        eduStudentService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:student:update')")
    public Result<String> update(@RequestBody @Valid EduStudentVO vo){
        eduStudentService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:student:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduStudentService.delete(idList);

        return Result.ok();
    }
}
