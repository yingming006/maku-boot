package cn.net.sigu.edu.convert;

import cn.net.sigu.edu.entity.EduExamEntity;
import cn.net.sigu.edu.vo.EduExamVO;

import java.util.List;

/**
* 考试信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
public interface EduExamConvert {
    EduExamEntity convert(EduExamVO vo);

    EduExamVO convert(EduExamEntity entity);

    List<EduExamVO> convertList(List<EduExamEntity> list);

}
