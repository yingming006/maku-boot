package net.maku.edu.convert;

import net.maku.edu.entity.EduExamCourseEntity;
import net.maku.edu.vo.EduExamCourseVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 考试科目表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-11
*/
@Mapper
public interface EduExamCourseConvert {
    EduExamCourseConvert INSTANCE = Mappers.getMapper(EduExamCourseConvert.class);

    EduExamCourseEntity convert(EduExamCourseVO vo);

    EduExamCourseVO convert(EduExamCourseEntity entity);

    List<EduExamCourseVO> convertList(List<EduExamCourseEntity> list);

}
