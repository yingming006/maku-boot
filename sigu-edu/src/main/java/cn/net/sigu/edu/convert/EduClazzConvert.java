package cn.net.sigu.edu.convert;

import cn.net.sigu.edu.entity.EduClazzEntity;
import cn.net.sigu.edu.vo.EduClazzVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 班级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduClazzConvert {
    EduClazzConvert INSTANCE = Mappers.getMapper(EduClazzConvert.class);

    EduClazzEntity convert(EduClazzVO vo);

    EduClazzVO convert(EduClazzEntity entity);

    List<EduClazzVO> convertList(List<EduClazzEntity> list);

}
