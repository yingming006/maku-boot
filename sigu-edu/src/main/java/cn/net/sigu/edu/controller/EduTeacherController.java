package cn.net.sigu.edu.controller;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduTeacherConvert;
import cn.net.sigu.edu.entity.EduTeacherEntity;
import cn.net.sigu.edu.service.EduTeacherService;
import cn.net.sigu.edu.query.EduTeacherQuery;
import cn.net.sigu.edu.vo.EduTeacherVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 教师信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/teacher")
@Tag(name="教师信息表")
@AllArgsConstructor
public class EduTeacherController {
    private final EduTeacherService eduTeacherService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:teacher:page')")
    public Result<PageResult<EduTeacherVO>> page(@Valid EduTeacherQuery query){
        PageResult<EduTeacherVO> page = eduTeacherService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:teacher:info')")
    public Result<EduTeacherVO> get(@PathVariable("id") Long id){
        EduTeacherEntity entity = eduTeacherService.getById(id);

        return Result.ok(EduTeacherConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:teacher:save')")
    public Result<String> save(@RequestBody EduTeacherVO vo){
        eduTeacherService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:teacher:update')")
    public Result<String> update(@RequestBody @Valid EduTeacherVO vo){
        eduTeacherService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:teacher:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduTeacherService.delete(idList);

        return Result.ok();
    }
}
