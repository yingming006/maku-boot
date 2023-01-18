package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduClazzVO;
import cn.net.sigu.edu.query.EduClazzQuery;
import cn.net.sigu.edu.entity.EduClazzEntity;

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
