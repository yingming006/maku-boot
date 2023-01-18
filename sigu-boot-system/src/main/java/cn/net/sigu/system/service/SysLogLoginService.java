package cn.net.sigu.system.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.system.entity.SysLogLoginEntity;
import cn.net.sigu.system.query.SysLogLoginQuery;
import cn.net.sigu.system.vo.SysLogLoginVO;

/**
 * 登录日志
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {

    /**
     * Page result.
     *
     * @param query the query
     * @return the page result
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     *
     * @param username  用户名
     * @param status    登录状态
     * @param operation 操作信息
     */
    void save(String username, Integer status, Integer operation);

    /**
     * 导出登录日志
     */
    void export();
}