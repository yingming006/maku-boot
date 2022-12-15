package net.maku.education.convert;

import net.maku.education.entity.EduExamEntity;
import net.maku.education.vo.EduExamVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 考试信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduExamConvert {
    EduExamConvert INSTANCE = Mappers.getMapper(EduExamConvert.class);

    EduExamEntity convert(EduExamVO vo);

    EduExamVO convert(EduExamEntity entity);

    List<EduExamVO> convertList(List<EduExamEntity> list);

}
