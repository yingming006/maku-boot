package net.maku.edu.convert;

import net.maku.edu.entity.EduClazzCourseTeacherEntity;
import net.maku.edu.entity.EduClazzEntity;
import net.maku.edu.vo.EduClazzVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
* 班级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper(componentModel = "spring")
public interface EduClazzConvert {

    EduClazzEntity convert(EduClazzVO vo);

    EduClazzVO convert(EduClazzEntity entity);

    List<EduClazzVO> convertList(List<EduClazzEntity> list);
}