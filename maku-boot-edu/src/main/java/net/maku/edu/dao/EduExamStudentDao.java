package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.vo.EduExamStudentVO;
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
     * @return
     */
    IPage<EduExamStudentVO> selectAllList(IPage<EduExamStudentEntity> page, @Param(Constants.WRAPPER) QueryWrapper<EduExamStudentEntity> wrapper);
}
