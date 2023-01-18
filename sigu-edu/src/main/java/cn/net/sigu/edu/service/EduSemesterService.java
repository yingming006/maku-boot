package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.entity.EduSemesterEntity;
import cn.net.sigu.edu.query.EduSemesterQuery;
import cn.net.sigu.edu.vo.EduSemesterVO;

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
