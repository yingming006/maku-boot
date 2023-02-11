package net.maku.edu.dao;

import net.maku.edu.entity.EduExamClazzEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.vo.EduExamClazzVO;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 考试班级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Mapper
public interface EduExamClazzDao extends BaseDao<EduExamClazzEntity> {

     List<EduExamClazzVO> selectIds(@Param("query") EduExamQuery query);

}
