package cn.net.sigu.system.convert;

import cn.net.sigu.system.entity.SysParamsEntity;
import cn.net.sigu.system.vo.SysParamsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 参数管理
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysParamsConvert {
    SysParamsConvert INSTANCE = Mappers.getMapper(SysParamsConvert.class);

    SysParamsEntity convert(SysParamsVO vo);

    SysParamsVO convert(SysParamsEntity entity);

    List<SysParamsVO> convertList(List<SysParamsEntity> list);

}