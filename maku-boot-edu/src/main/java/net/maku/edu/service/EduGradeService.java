package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
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

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduGradeVO> page(EduGradeQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduGradeVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduGradeVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
