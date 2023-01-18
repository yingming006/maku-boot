package cn.net.sigu.quartz.convert;

import cn.net.sigu.quartz.vo.ScheduleJobVO;
import cn.net.sigu.quartz.entity.ScheduleJobEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 定时任务
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface ScheduleJobConvert {
    ScheduleJobConvert INSTANCE = Mappers.getMapper(ScheduleJobConvert.class);

    ScheduleJobEntity convert(ScheduleJobVO vo);

    ScheduleJobVO convert(ScheduleJobEntity entity);

    List<ScheduleJobVO> convertList(List<ScheduleJobEntity> list);

}