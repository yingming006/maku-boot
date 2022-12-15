package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduExamVO;
import net.maku.education.query.EduExamQuery;
import net.maku.education.entity.EduExamEntity;

import java.util.List;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamService extends BaseService<EduExamEntity> {

    PageResult<EduExamVO> page(EduExamQuery query);

    void save(EduExamVO vo);

    void update(EduExamVO vo);

    void delete(List<Long> idList);
}
