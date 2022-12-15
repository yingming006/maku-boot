package net.maku.education.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.education.convert.EduExamScoreConvert;
import net.maku.education.entity.EduExamScoreEntity;
import net.maku.education.service.EduExamScoreService;
import net.maku.education.query.EduExamScoreQuery;
import net.maku.education.vo.EduExamScoreVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 考试成绩表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/score")
@Tag(name="考试成绩表")
@AllArgsConstructor
public class EduExamScoreController {
    private final EduExamScoreService eduExamScoreService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('edu:score:page')")
    public Result<PageResult<EduExamScoreVO>> page(@Valid EduExamScoreQuery query){
        PageResult<EduExamScoreVO> page = eduExamScoreService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:score:info')")
    public Result<EduExamScoreVO> get(@PathVariable("id") Long id){
        EduExamScoreEntity entity = eduExamScoreService.getById(id);

        return Result.ok(EduExamScoreConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:score:save')")
    public Result<String> save(@RequestBody EduExamScoreVO vo){
        eduExamScoreService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:score:update')")
    public Result<String> update(@RequestBody @Valid EduExamScoreVO vo){
        eduExamScoreService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:score:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        eduExamScoreService.delete(idList);

        return Result.ok();
    }
}
