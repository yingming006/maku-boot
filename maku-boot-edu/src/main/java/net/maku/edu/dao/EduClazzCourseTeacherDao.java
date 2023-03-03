package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.entity.EduClazzCourseTeacherEntity;
import net.maku.edu.query.EduClazzCourseTeacherQuery;
import net.maku.edu.vo.EduClazzCourseTeacherVO;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 班级课程关联表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-2-15
*/
@Mapper
public interface EduClazzCourseTeacherDao extends BaseDao<EduClazzCourseTeacherEntity> {

    List<EduClazzCourseTeacherVO> list(@Param(Constants.WRAPPER) QueryWrapper<EduClazzCourseTeacherQuery> wrapper);
}
