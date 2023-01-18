package cn.net.sigu.system.dao;

import cn.net.sigu.system.entity.SysLogLoginEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}