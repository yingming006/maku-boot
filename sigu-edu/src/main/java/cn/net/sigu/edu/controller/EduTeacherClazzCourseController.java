package cn.net.sigu.edu.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 教师_班级_课程关联表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@RestController
@RequestMapping("edu/course")
@Tag(name="教师_班级_课程关联表")
@AllArgsConstructor
public class EduTeacherClazzCourseController {
//    private final EduTeacherClazzCourseService eduTeacherClazzCourseService;

//    @GetMapping("page")
//    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('edu:course:page')")
//    public Result<PageResult<EduTeacherClazzCourseVO>> page(@Valid EduTeacherClazzCourseQuery query){
//        PageResult<EduTeacherClazzCourseVO> page = eduTeacherClazzCourseService.page(query);
//
//        return Result.ok(page);
//    }
//
//    @GetMapping("{id}")
//    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('edu:course:info')")
//    public Result<EduTeacherClazzCourseVO> get(@PathVariable("id") Long id){
//        EduTeacherClazzCourseEntity entity = eduTeacherClazzCourseService.getById(id);
//
//        return Result.ok(EduTeacherClazzCourseConvert.INSTANCE.convert(entity));
//    }
//
//    @PostMapping
//    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('edu:course:save')")
//    public Result<String> save(@RequestBody EduTeacherClazzCourseVO vo){
//        eduTeacherClazzCourseService.save(vo);
//
//        return Result.ok();
//    }
//
//    @PutMapping
//    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('edu:course:update')")
//    public Result<String> update(@RequestBody @Valid EduTeacherClazzCourseVO vo){
//        eduTeacherClazzCourseService.update(vo);
//
//        return Result.ok();
//    }
//
//    @DeleteMapping
//    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('edu:course:delete')")
//    public Result<String> delete(@RequestBody List<Long> idList){
//        eduTeacherClazzCourseService.delete(idList);
//
//        return Result.ok();
//    }
}
