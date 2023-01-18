package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.entity.EduExamCourseEntity;
import cn.net.sigu.edu.query.EduExamQuery;
import cn.net.sigu.edu.vo.EduExamCourseVO;

import java.util.List;

/**
 * 考试科目表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-11
 */
public interface EduExamCourseService extends BaseService<EduExamCourseEntity> {

    /**
     * 查询考试科目列表
     * @param query
     * @return
     */
    List<EduExamCourseEntity> list(EduExamQuery query);

    void save(EduExamCourseVO vo);

    void update(EduExamCourseVO vo);

    void delete(List<Long> idList);
}
