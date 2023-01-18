package cn.net.sigu.system.dao;

import cn.net.sigu.system.entity.SysOrgEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构管理
 * 
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysOrgDao extends BaseDao<SysOrgEntity> {

    List<SysOrgEntity> getList(Map<String, Object> params);

    /**
     * 获取所有机构的id、pid列表
     */
    List<SysOrgEntity> getIdAndPidList();

}