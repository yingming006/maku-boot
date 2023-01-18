package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduExamVO;
import cn.net.sigu.edu.query.EduExamQuery;
import cn.net.sigu.edu.entity.EduExamEntity;

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
