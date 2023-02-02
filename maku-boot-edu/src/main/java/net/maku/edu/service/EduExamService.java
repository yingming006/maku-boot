package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.edu.vo.EduExamVO;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.entity.EduExamEntity;

import java.util.List;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamService extends BaseService<EduExamEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduExamVO> page(EduExamQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduExamVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduExamVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
