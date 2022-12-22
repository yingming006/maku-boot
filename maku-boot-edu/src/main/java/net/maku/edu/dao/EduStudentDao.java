package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import net.maku.edu.vo.EduStudentVO;
import net.maku.framework.common.dao.BaseDao;
import net.maku.edu.entity.EduStudentEntity;
import net.maku.framework.common.query.Query;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Mapper
public interface EduStudentDao extends BaseDao<EduStudentEntity> {

    IPage<EduStudentVO> selectListPage(IPage<EduStudentEntity> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<EduStudentEntity> wrapper);
}
