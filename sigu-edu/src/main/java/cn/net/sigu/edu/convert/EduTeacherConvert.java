package cn.net.sigu.edu.convert;

import cn.net.sigu.edu.entity.EduTeacherEntity;
import cn.net.sigu.edu.vo.EduTeacherVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 教师信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduTeacherConvert {
    EduTeacherConvert INSTANCE = Mappers.getMapper(EduTeacherConvert.class);

    EduTeacherEntity convert(EduTeacherVO vo);

    EduTeacherVO convert(EduTeacherEntity entity);

    List<EduTeacherVO> convertList(List<EduTeacherEntity> list);

}
