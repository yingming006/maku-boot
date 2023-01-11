package net.maku.edu.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.edu.entity.EduExamCourseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 考试科目表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-11
*/
@Mapper
public interface EduExamCourseDao extends BaseDao<EduExamCourseEntity> {

}
