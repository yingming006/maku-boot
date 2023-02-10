package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.entity.EduStudentEntity;
import net.maku.edu.vo.EduStudentVO;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Mapper
public interface EduStudentDao extends BaseDao<EduStudentEntity> {

    IPage<EduStudentVO> selectAllPage(IPage<EduStudentEntity> page, @Param(Constants.WRAPPER) QueryWrapper<EduStudentEntity> wrapper);

    EduStudentVO selectById(@Param("id") Long id);
}
