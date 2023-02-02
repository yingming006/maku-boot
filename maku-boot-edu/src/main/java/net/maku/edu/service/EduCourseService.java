package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
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

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduCourseVO> page(EduCourseQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduCourseVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduCourseVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
