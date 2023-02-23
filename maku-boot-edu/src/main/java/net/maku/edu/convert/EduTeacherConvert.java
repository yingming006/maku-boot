package net.maku.edu.convert;

import net.maku.edu.entity.EduTeacherEntity;
import net.maku.edu.vo.EduTeacherVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 教师信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper(componentModel = "spring")
public interface EduTeacherConvert {

    EduTeacherEntity convert(EduTeacherVO vo);

    EduTeacherVO convert(EduTeacherEntity entity);

    List<EduTeacherVO> convertList(List<EduTeacherEntity> list);

}
