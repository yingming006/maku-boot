package net.maku.edu.service;

import net.maku.edu.entity.EduExamClazzEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.edu.vo.EduExamCourseVO;
import net.maku.edu.query.EduExamCourseQuery;
import net.maku.edu.entity.EduExamCourseEntity;

import java.util.List;

/**
 * 考试科目表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-11
 */
public interface EduExamCourseService extends BaseService<EduExamCourseEntity> {

    List<EduExamCourseEntity> list(EduExamQuery query);

    void save(EduExamCourseVO vo);

    void update(EduExamCourseVO vo);

    void delete(List<Long> idList);
}
