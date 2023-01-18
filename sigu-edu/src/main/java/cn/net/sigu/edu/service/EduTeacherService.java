package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduTeacherVO;
import cn.net.sigu.edu.query.EduTeacherQuery;
import cn.net.sigu.edu.entity.EduTeacherEntity;

import java.util.List;

/**
 * 教师信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduTeacherService extends BaseService<EduTeacherEntity> {

    PageResult<EduTeacherVO> page(EduTeacherQuery query);

    void save(EduTeacherVO vo);

    void update(EduTeacherVO vo);

    void delete(List<Long> idList);
}
