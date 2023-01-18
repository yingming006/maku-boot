package cn.net.sigu.message.service;

import cn.net.sigu.message.vo.SmsLogVO;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.message.entity.SmsLogEntity;
import cn.net.sigu.message.query.SmsLogQuery;

/**
 * 短信日志
 *
 * @author 阿沐 babamu@126.com
 */
public interface SmsLogService extends BaseService<SmsLogEntity> {

    PageResult<SmsLogVO> page(SmsLogQuery query);

}