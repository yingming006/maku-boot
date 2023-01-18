package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduStudentVO;
import cn.net.sigu.edu.query.EduStudentQuery;
import cn.net.sigu.edu.entity.EduStudentEntity;

import java.util.List;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduStudentService extends BaseService<EduStudentEntity> {

    PageResult<EduStudentVO> page(EduStudentQuery query);

    void save(EduStudentVO vo);

    void update(EduStudentVO vo);

    void delete(List<Long> idList);
}
