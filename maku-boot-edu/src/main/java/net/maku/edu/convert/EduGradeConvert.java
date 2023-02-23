package net.maku.edu.convert;

import net.maku.edu.entity.EduGradeEntity;
import net.maku.edu.vo.EduGradeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 年级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-20
*/
@Mapper(componentModel = "spring")
public interface EduGradeConvert {

    EduGradeEntity convert(EduGradeVO vo);

    EduGradeVO convert(EduGradeEntity entity);

    List<EduGradeVO> convertList(List<EduGradeEntity> list);

}