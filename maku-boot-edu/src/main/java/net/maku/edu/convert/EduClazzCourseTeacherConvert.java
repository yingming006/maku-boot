package net.maku.edu.convert;

import net.maku.edu.entity.EduClazzCourseTeacherEntity;
import net.maku.edu.vo.EduClazzCourseTeacherVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
* 班级、课程、教师关联表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper(componentModel = "spring")
public interface EduClazzCourseTeacherConvert {

    EduClazzCourseTeacherEntity convert(EduClazzCourseTeacherVO vo);

    EduClazzCourseTeacherVO convert(EduClazzCourseTeacherEntity entity);

    List<EduClazzCourseTeacherVO> convertList(List<EduClazzCourseTeacherEntity> list);

    List<EduClazzCourseTeacherEntity> convertToList(List<EduClazzCourseTeacherVO> list);
}