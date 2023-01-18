package cn.net.sigu.system.dao;

import cn.net.sigu.system.entity.SysRoleEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 角色管理
 * 
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

    /**
     * 根据用户ID，获取用户最大的数据范围
     */
    Integer getDataScopeByUserId(@Param("userId") Long userId);

}
