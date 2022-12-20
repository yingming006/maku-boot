package net.maku.edu.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.edu.vo.EduCourseVO;
import net.maku.edu.query.EduCourseQuery;
import net.maku.edu.entity.EduCourseEntity;

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
