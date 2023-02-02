package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 考试成绩表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/examScore")
@Tag(name="考试成绩表")
@AllArgsConstructor
public class EduExamScoreController {

    @Autowired
    private EduExamScoreService eduExamScoreService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:examScore:page')")
    public Result<PageResult<EduExamScoreVO>> page(@Valid EduExamScoreQuery query){
        PageResult<EduExamScoreVO> page = eduExamScoreService.page(query);

        return Result.ok(page);
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:examScore:save')")
    public Result<String> save(@RequestBody EduExamScoreVO vo){
        eduExamScoreService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:examScore:update')")
    public Result<String> update(@RequestBody @Valid EduExamScoreVO vo){
        eduExamScoreService.update(vo);
        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:examScore:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduExamScoreService.delete(idList);

        return Result.ok();
    }
}
