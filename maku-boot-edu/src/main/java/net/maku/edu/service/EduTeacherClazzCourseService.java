package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.edu.vo.EduTeacherClazzCourseVO;
import net.maku.edu.query.EduTeacherClazzCourseQuery;
import net.maku.edu.entity.EduTeacherClazzCourseEntity;

import java.util.List;

/**
 * 教师_班级_课程关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduTeacherClazzCourseService extends BaseService<EduTeacherClazzCourseEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduTeacherClazzCourseVO> page(EduTeacherClazzCourseQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduTeacherClazzCourseVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduTeacherClazzCourseVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
