package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduCourseVO;
import cn.net.sigu.edu.query.EduCourseQuery;
import cn.net.sigu.edu.entity.EduCourseEntity;

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
