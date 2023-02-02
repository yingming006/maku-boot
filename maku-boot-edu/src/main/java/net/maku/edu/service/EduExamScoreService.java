package net.maku.edu.service;

import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;

import java.util.List;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamScoreService extends BaseService<EduExamScoreEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduExamScoreVO> page(EduExamScoreQuery query);

    /**
     * 保存学生成绩
     * @param vo
     */
    void save(EduExamScoreVO vo);

    /**
     * 更新学生成绩
     * @param vo
     */
    void update(EduExamScoreVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
