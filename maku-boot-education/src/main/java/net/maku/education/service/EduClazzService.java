package net.maku.education.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduClazzVO;
import net.maku.education.query.EduClazzQuery;
import net.maku.education.entity.EduClazzEntity;

import java.util.List;

/**
 * 班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduClazzService extends BaseService<EduClazzEntity> {

    PageResult<EduClazzVO> page(EduClazzQuery query);

    void save(EduClazzVO vo);

    void update(EduClazzVO vo);

    void delete(List<Long> idList);
}
