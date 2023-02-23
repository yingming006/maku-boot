package net.maku.edu.convert;

import net.maku.edu.entity.EduCourseEntity;
import net.maku.edu.vo.EduCourseVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 课程信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper(componentModel = "spring")
public interface EduCourseConvert {

    EduCourseEntity convert(EduCourseVO vo);

    EduCourseVO convert(EduCourseEntity entity);

    List<EduCourseVO> convertList(List<EduCourseEntity> list);

}
