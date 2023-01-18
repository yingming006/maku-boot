package cn.net.sigu.security.service;

import cn.net.sigu.framework.security.mobile.MobileVerifyCodeService;
import lombok.AllArgsConstructor;
import cn.net.sigu.api.module.message.SmsApi;
import org.springframework.stereotype.Service;

/**
 * 短信验证码效验
 *
 * @author 阿沐 babamu@126.com
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsApi.verifyCode(mobile, code);
    }
}
