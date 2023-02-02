package net.maku.edu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    /**
     * 分页查询
     * @param page
     * @param wrapper
     * @param query
     * @return
     */
    IPage<EduStudentVO> selectListPage(IPage<EduStudentEntity> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<EduStudentEntity> wrapper);
}
