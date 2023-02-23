package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.maku.edu.entity.EduClazzEntity;
import net.maku.edu.query.EduClazzQuery;
import net.maku.edu.vo.EduClazzVO;
import net.maku.edu.vo.SysDictVO;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Mapper
public interface EduClazzDao extends BaseDao<EduClazzEntity> {

    @Select("SELECT c.id AS dictValue, CONCAT(g.name, c.name) AS dictLabel\n" +
            "FROM edu_clazz c\n" +
            "LEFT JOIN edu_grade g ON c.grade_id = g.id\n" +
            "WHERE c.deleted = 0\n" +
            "AND c.grade_id = #{query.gradeId}\n" +
            "ORDER BY c.entrance_year DESC")
    List<SysDictVO.DictData> getDictData(@Param("query") EduClazzQuery query);

    EduClazzVO selectVOById(Long id);
}
