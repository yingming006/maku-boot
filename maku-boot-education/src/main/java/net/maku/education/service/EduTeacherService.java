package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduTeacherVO;
import net.maku.education.query.EduTeacherQuery;
import net.maku.education.entity.EduTeacherEntity;

import java.util.List;

/**
 * 教师信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduTeacherService extends BaseService<EduTeacherEntity> {

    PageResult<EduTeacherVO> page(EduTeacherQuery query);

    void save(EduTeacherVO vo);

    void update(EduTeacherVO vo);

    void delete(List<Long> idList);
}
