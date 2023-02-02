package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.service.EduExamStudentService;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.edu.vo.EduExamStudentVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PreAuthorize("hasAuthority('edu:examStudent:page')")
    public Result<PageResult<EduExamStudentScoreVO>> page(@Valid EduExamStudentQuery query) {
        PageResult<EduExamStudentScoreVO> page = eduExamStudentService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('edu:examStudent:info')")
    public Result<EduExamStudentScoreVO> get(@PathVariable("id") Long id) {
        return eduExamStudentService.getById(id);
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('edu:examStudent:save')")
    public Result<String> save(@RequestBody EduExamStudentVO vo) {
        eduExamStudentService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('edu:examStudent:update')")
    public Result<String> update(@RequestBody @Valid EduExamStudentVO vo) {
        eduExamStudentService.update(vo);

        return Result.ok();
    }

    @PutMapping("updateScore")
    @Operation(summary = "修改成绩")
    @PreAuthorize("hasAuthority('edu:examStudent:update')")
    public Result<String> updateScore(@RequestBody @Valid EduExamStudentScoreVO vo) {
        eduExamStudentService.updateScore(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('edu:examStudent:delete')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        eduExamStudentService.delete(idList);

        return Result.ok();
    }

    @GetMapping("exportTemplate")
    @Operation(summary = "导出模板")
    @PreAuthorize("hasAuthority('edu:examStudent:export')")
    public void exportTemplate(@Valid EduExamStudentQuery query) {
        eduExamStudentService.exportTemplate(query);
    }

    @PostMapping("import")
    @Operation(summary = "导入成绩")
    @PreAuthorize("hasAuthority('edu:examStudent:import')")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file, @Valid EduExamStudentQuery query) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        eduExamStudentService.importByExcel(file, query);

        return Result.ok();
    }

    @GetMapping("pageWithoutScore")
    @Operation(summary = "分页，不带成绩，导出模板")
    @PreAuthorize("hasAuthority('edu:examStudent:page')")
    public Result<PageResult<EduExamStudentScoreVO>> pageWithoutScore(@Valid EduExamStudentQuery query){
        PageResult<EduExamStudentScoreVO> page = eduExamStudentService.pageWithoutScore(query);

        return Result.ok(page);
    }
}
