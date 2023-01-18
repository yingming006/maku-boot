package cn.net.sigu.system.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.system.entity.SysPostEntity;
import cn.net.sigu.system.query.SysPostQuery;
import cn.net.sigu.system.vo.SysPostVO;

import java.util.List;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}