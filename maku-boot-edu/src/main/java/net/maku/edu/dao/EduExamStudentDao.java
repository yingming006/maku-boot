package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.framework.common.dao.BaseDao;
import net.maku.edu.entity.EduExamStudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 考试学生信息
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-28
*/
@Mapper
public interface EduExamStudentDao extends BaseDao<EduExamStudentEntity> {

    IPage<EduExamStudentScoreVO> selectAllList(IPage<EduExamStudentEntity> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<EduExamStudentEntity> wrapper, @Param("query") EduExamStudentQuery query);
}
