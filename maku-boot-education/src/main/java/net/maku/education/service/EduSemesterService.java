package net.maku.education.service;

import net.maku.education.entity.EduSemesterEntity;
import net.maku.education.query.EduSemesterQuery;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.education.vo.EduSemesterVO;

import java.util.List;

/**
 * 学期信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-19
 */
public interface EduSemesterService extends BaseService<EduSemesterEntity> {

    PageResult<EduSemesterVO> page(EduSemesterQuery query);

    void save(EduSemesterVO vo);

    void update(EduSemesterVO vo);

    void delete(List<Long> idList);
}
