package net.maku.edu.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.edu.vo.EduGradeVO;
import net.maku.edu.query.EduGradeQuery;
import net.maku.edu.entity.EduGradeEntity;

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