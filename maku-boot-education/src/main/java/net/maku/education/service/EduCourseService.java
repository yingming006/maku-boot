package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduCourseVO;
import net.maku.education.query.EduCourseQuery;
import net.maku.education.entity.EduCourseEntity;

import java.util.List;

/**
 * 课程信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduCourseService extends BaseService<EduCourseEntity> {

    PageResult<EduCourseVO> page(EduCourseQuery query);

    void save(EduCourseVO vo);

    void update(EduCourseVO vo);

    void delete(List<Long> idList);
}
