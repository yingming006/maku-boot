package cn.net.sigu.system.dao;

import cn.net.sigu.system.entity.SysDictDataEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
import cn.net.sigu.system.vo.SysDictVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 字典数据
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysDictDataDao extends BaseDao<SysDictDataEntity> {

    @Select("${sql}")
    List<SysDictVO.DictData> getListForSql(@Param("sql") String sql);

    @Select("${sql}")
    List<SysDictDataEntity> getListByDynamicSQL(@Param("sql") String sql);
}
