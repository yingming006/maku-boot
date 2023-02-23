package net.maku.edu.convert;

import net.maku.edu.entity.EduSemesterEntity;
import net.maku.edu.vo.EduSemesterVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 学期信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-19
*/
@Mapper(componentModel = "spring")
public interface EduSemesterConvert {

    EduSemesterEntity convert(EduSemesterVO vo);

    EduSemesterVO convert(EduSemesterEntity entity);

    List<EduSemesterVO> convertList(List<EduSemesterEntity> list);

}
