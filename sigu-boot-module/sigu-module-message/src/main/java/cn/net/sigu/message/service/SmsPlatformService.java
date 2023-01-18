package cn.net.sigu.message.service;

import cn.net.sigu.message.sms.config.SmsConfig;
import cn.net.sigu.message.vo.SmsPlatformVO;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.message.entity.SmsPlatformEntity;
import cn.net.sigu.message.query.SmsPlatformQuery;

import java.util.List;

/**
 * 短信平台
 *
 * @author 阿沐 babamu@126.com
 */
public interface SmsPlatformService extends BaseService<SmsPlatformEntity> {

    PageResult<SmsPlatformVO> page(SmsPlatformQuery query);

    /**
     * 启用的短信平台列表
     */
    List<SmsConfig> listByEnable();

    void save(SmsPlatformVO vo);

    void update(SmsPlatformVO vo);

    void delete(List<Long> idList);

}