package net.maku.edu.service;

import net.maku.edu.entity.EduExamCourseEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.vo.EduExamCourseVO;
import net.maku.framework.mybatis.service.BaseService;

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

    /**
     * 保存
     * @param vo
     */
    void save(EduExamCourseVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduExamCourseVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
