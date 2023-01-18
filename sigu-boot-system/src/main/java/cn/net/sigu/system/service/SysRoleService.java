package cn.net.sigu.system.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.system.entity.SysRoleEntity;
import cn.net.sigu.system.query.SysRoleQuery;
import cn.net.sigu.system.vo.SysRoleDataScopeVO;
import cn.net.sigu.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 * 
 * @author 阿沐 babamu@126.com
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageResult<SysRoleVO> page(SysRoleQuery query);

	List<SysRoleVO> getList(SysRoleQuery query);

	void save(SysRoleVO vo);

	void update(SysRoleVO vo);

	void dataScope(SysRoleDataScopeVO vo);

	void delete(List<Long> idList);
}
