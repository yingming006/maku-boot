package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduExamScoreVO;
import net.maku.education.query.EduExamScoreQuery;
import net.maku.education.entity.EduExamScoreEntity;

import java.util.List;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamScoreService extends BaseService<EduExamScoreEntity> {

    PageResult<EduExamScoreVO> page(EduExamScoreQuery query);

    void save(EduExamScoreVO vo);

    void update(EduExamScoreVO vo);

    void delete(List<Long> idList);
}
