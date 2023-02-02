package net.maku.edu.service;

import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.edu.vo.EduExamStudentVO;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.framework.common.utils.Result;

import java.util.List;

/**
 * 考试学生信息
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-28
 */
public interface EduExamStudentService extends BaseService<EduExamStudentEntity> {

    PageResult<EduExamStudentScoreVO> page(EduExamStudentQuery query);

    Result<EduExamStudentScoreVO> getById(Long id);

    void save(EduExamStudentVO vo);

    void update(EduExamStudentVO vo);

    void delete(List<Long> idList);
}
