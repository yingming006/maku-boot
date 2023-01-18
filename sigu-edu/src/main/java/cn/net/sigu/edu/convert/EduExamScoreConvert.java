package cn.net.sigu.edu.convert;

import cn.net.sigu.edu.entity.EduExamScoreEntity;
import cn.net.sigu.edu.vo.EduExamScoreVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 考试成绩表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduExamScoreConvert {
    EduExamScoreConvert INSTANCE = Mappers.getMapper(EduExamScoreConvert.class);

    EduExamScoreEntity convert(EduExamScoreVO vo);

    EduExamScoreVO convert(EduExamScoreEntity entity);

    List<EduExamScoreVO> convertList(List<EduExamScoreEntity> list);

}
