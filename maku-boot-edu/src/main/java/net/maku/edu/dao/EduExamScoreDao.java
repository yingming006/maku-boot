package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.edu.vo.EduStudentVO;
import net.maku.framework.common.dao.BaseDao;
import net.maku.edu.entity.EduExamScoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Mapper
public interface EduExamScoreDao extends BaseDao<EduExamScoreEntity> {

    IPage<EduExamScoreVO> selectListPage(IPage<EduExamScoreEntity> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<EduExamScoreEntity> wrapper, @Param("query") EduExamScoreQuery query);

    Long selectListCount(@Param(Constants.WRAPPER) LambdaQueryWrapper<EduExamScoreEntity> wrapper, EduExamScoreQuery query);

    List<EduExamScoreVO> selectList(@Param(Constants.WRAPPER) LambdaQueryWrapper<EduExamScoreEntity> wrapper, @Param("query") EduExamScoreQuery query);
}
