package cn.net.sigu.edu.dao;

import cn.net.sigu.edu.entity.EduStudentEntity;
import cn.net.sigu.framework.common.dao.BaseDao;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import cn.net.sigu.edu.vo.EduStudentVO;
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

    IPage<EduStudentVO> selectListPage(IPage<EduStudentEntity> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<EduStudentEntity> wrapper);
}
