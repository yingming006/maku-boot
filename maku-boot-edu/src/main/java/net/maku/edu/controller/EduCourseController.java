package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduCourseConvert;
import net.maku.edu.entity.EduCourseEntity;
import net.maku.edu.query.EduCourseQuery;
import net.maku.edu.service.EduCourseService;
import net.maku.edu.vo.EduCourseVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 课程信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/course")
@Tag(name="课程信息表")
@AllArgsConstructor
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:course:page')")
    public Result<PageResult<EduCourseVO>> page(@Valid EduCourseQuery query){
        PageResult<EduCourseVO> page = eduCourseService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:course:info')")
    public Result<EduCourseVO> get(@PathVariable("id") Long id){
        EduCourseEntity entity = eduCourseService.getById(id);

        return Result.ok(EduCourseConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:course:save')")
    public Result<String> save(@RequestBody EduCourseVO vo){
        eduCourseService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:course:update')")
    public Result<String> update(@RequestBody @Valid EduCourseVO vo){
        eduCourseService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:course:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduCourseService.delete(idList);

        return Result.ok();
    }
}
