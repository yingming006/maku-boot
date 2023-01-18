package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduGradeVO;
import cn.net.sigu.edu.query.EduGradeQuery;
import cn.net.sigu.edu.entity.EduGradeEntity;

import java.util.List;

/**
 * 年级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-20
 */
public interface EduGradeService extends BaseService<EduGradeEntity> {

    PageResult<EduGradeVO> page(EduGradeQuery query);

    void save(EduGradeVO vo);

    void update(EduGradeVO vo);

    void delete(List<Long> idList);
}