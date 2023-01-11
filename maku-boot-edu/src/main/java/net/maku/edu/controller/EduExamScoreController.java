package net.maku.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.utils.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("{examId}/{studentId}")
    @Operation(summary = "获取当前考试单个学生成绩")
    @PreAuthorize("hasAuthority('edu:score:info')")
    public Result<EduExamScoreVO> get(@Valid EduExamScoreQuery query){
        EduExamScoreVO entity = eduExamScoreService.getByExamIdWithStuId(query);
        return Result.ok(entity);
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

    @GetMapping("exportTemplate/{examId}")
    @Operation(summary = "导出模板")
    @PreAuthorize("hasAuthority('edu:score:export')")
    public void exportTemplate(@Valid EduExamScoreQuery query) {
        eduExamScoreService.exportTemplate(query);
    }

    @PostMapping("import")
    @Operation(summary = "导入用户")
    @PreAuthorize("hasAuthority('edu:score:import')")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file, @Valid EduExamScoreQuery query) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        eduExamScoreService.importByExcel(file, query);

        return Result.ok();
    }

    @GetMapping("export")
    @Operation(summary = "导出用户")
    @PreAuthorize("hasAuthority('edu:score:export')")
    public void export() {
//        sysUserService.export();
    }
}
