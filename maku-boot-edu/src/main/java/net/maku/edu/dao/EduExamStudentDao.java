package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* 考试学生信息
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-28
*/
@Mapper
public interface EduExamStudentDao extends BaseDao<EduExamStudentEntity> {

    /**
     * 分页查询
     * @param page
     * @param wrapper
     * @param query
     * @return
     */
    IPage<EduExamStudentScoreVO> selectAllList(IPage<EduExamStudentEntity> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<EduExamStudentEntity> wrapper, @Param("query") EduExamStudentQuery query);
}
