package cn.net.sigu.edu.controller;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduExamConvert;
import cn.net.sigu.edu.entity.EduExamEntity;
import cn.net.sigu.edu.query.EduExamQuery;
import cn.net.sigu.edu.service.EduExamService;
import cn.net.sigu.edu.vo.EduExamVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 考试信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/exam")
@Tag(name="考试信息表")
@AllArgsConstructor
public class EduExamController {
    private final EduExamService eduExamService;

    private final EduExamConvert eduExamConvert;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:exam:page')")
    public Result<PageResult<EduExamVO>> page(@Valid EduExamQuery query){
        PageResult<EduExamVO> page = eduExamService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:exam:info')")
    public Result<EduExamVO> get(@PathVariable("id") Long id){
        EduExamEntity entity = eduExamService.getById(id);
        return Result.ok(eduExamConvert.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:exam:save')")
    public Result<String> save(@RequestBody EduExamVO vo){
        eduExamService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:exam:update')")
    public Result<String> update(@RequestBody @Valid EduExamVO vo){
        eduExamService.update(vo);
        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:exam:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduExamService.delete(idList);

        return Result.ok();
    }
}
