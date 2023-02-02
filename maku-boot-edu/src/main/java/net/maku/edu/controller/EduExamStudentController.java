package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.edu.convert.EduExamStudentConvert;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.service.EduExamStudentService;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.vo.EduExamStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 考试学生信息
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-28
*/
@RestController
@RequestMapping("edu/examStudent")
@Tag(name="考试学生信息")
@AllArgsConstructor
public class EduExamStudentController {

    @Autowired
    private EduExamStudentService eduExamStudentService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('maku:student:page')")
    public Result<PageResult<EduExamStudentScoreVO>> page(@Valid EduExamStudentQuery query) {
        PageResult<EduExamStudentScoreVO> page = eduExamStudentService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('maku:student:info')")
    public Result<EduExamStudentScoreVO> get(@PathVariable("id") Long id) {
        return eduExamStudentService.getById(id);
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('maku:student:save')")
    public Result<String> save(@RequestBody EduExamStudentVO vo) {
        eduExamStudentService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('maku:student:update')")
    public Result<String> update(@RequestBody @Valid EduExamStudentVO vo) {
        eduExamStudentService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('maku:student:delete')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        eduExamStudentService.delete(idList);

        return Result.ok();
    }
}
