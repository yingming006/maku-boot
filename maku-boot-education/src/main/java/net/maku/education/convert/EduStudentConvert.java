package net.maku.education.convert;

import net.maku.education.entity.EduStudentEntity;
import net.maku.education.vo.EduStudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 学生信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduStudentConvert {
    EduStudentConvert INSTANCE = Mappers.getMapper(EduStudentConvert.class);

    EduStudentEntity convert(EduStudentVO vo);

    EduStudentVO convert(EduStudentEntity entity);

    List<EduStudentVO> convertList(List<EduStudentEntity> list);

}
