package net.maku.edu.service;

import net.maku.edu.entity.EduExamClazzEntity;
import net.maku.edu.entity.EduExamEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.vo.EduExamVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;

import java.util.List;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamClazzService extends BaseService<EduExamClazzEntity> {

    List<EduExamClazzEntity> list(EduExamQuery query);

    void save(EduExamVO vo);

    void update(EduExamVO vo);
}
