package net.maku.education.convert;

import net.maku.education.entity.EduSemesterEntity;
import net.maku.education.vo.EduSemesterVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 学期信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-19
*/
@Mapper
public interface EduSemesterConvert {
    EduSemesterConvert INSTANCE = Mappers.getMapper(EduSemesterConvert.class);

    EduSemesterEntity convert(EduSemesterVO vo);

    EduSemesterVO convert(EduSemesterEntity entity);

    List<EduSemesterVO> convertList(List<EduSemesterEntity> list);

}
