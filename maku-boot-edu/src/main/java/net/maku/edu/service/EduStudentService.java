package net.maku.edu.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.edu.vo.EduStudentVO;
import net.maku.edu.query.EduStudentQuery;
import net.maku.edu.entity.EduStudentEntity;

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
