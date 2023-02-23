package net.maku.edu.convert;

import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.vo.EduExamStudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 考试学生信息
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-28
*/
@Mapper(componentModel = "spring")
public interface EduExamStudentConvert {

    EduExamStudentEntity convert(EduExamStudentVO vo);

    EduExamStudentVO convert(EduExamStudentEntity entity);

    List<EduExamStudentVO> convertList(List<EduExamStudentEntity> list);

    List<EduExamStudentEntity> convertToList(List<EduExamStudentVO> list);

}
