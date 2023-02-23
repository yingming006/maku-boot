package net.maku.edu.convert;

import net.maku.edu.entity.EduStudentEntity;
import net.maku.edu.vo.EduStudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 学生信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper(componentModel = "spring")
public interface EduStudentConvert {

    EduStudentEntity convert(EduStudentVO vo);

    EduStudentVO convert(EduStudentEntity entity);

    List<EduStudentVO> convertList(List<EduStudentEntity> list);

}
