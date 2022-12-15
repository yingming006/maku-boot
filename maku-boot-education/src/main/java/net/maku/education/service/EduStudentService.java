package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduStudentVO;
import net.maku.education.query.EduStudentQuery;
import net.maku.education.entity.EduStudentEntity;

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
