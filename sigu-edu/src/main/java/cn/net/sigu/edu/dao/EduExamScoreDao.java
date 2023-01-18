package cn.net.sigu.edu.dao;

import cn.net.sigu.edu.entity.EduExamScoreEntity;
import cn.net.sigu.edu.query.EduExamScoreQuery;
import cn.net.sigu.framework.common.dao.BaseDao;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import cn.net.sigu.edu.vo.EduExamScoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<EduExamScoreVO> selectAllList(@Param(Constants.WRAPPER) LambdaQueryWrapper<EduExamScoreEntity> wrapper, @Param("query") EduExamScoreQuery query);
}
