package net.maku.edu.convert;

import net.maku.edu.entity.EduTeacherClazzCourseEntity;
import net.maku.edu.vo.EduTeacherClazzCourseVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 教师_班级_课程关联表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduTeacherClazzCourseConvert {
    EduTeacherClazzCourseConvert INSTANCE = Mappers.getMapper(EduTeacherClazzCourseConvert.class);

    EduTeacherClazzCourseEntity convert(EduTeacherClazzCourseVO vo);

    EduTeacherClazzCourseVO convert(EduTeacherClazzCourseEntity entity);

    List<EduTeacherClazzCourseVO> convertList(List<EduTeacherClazzCourseEntity> list);

}
