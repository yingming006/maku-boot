package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.edu.vo.EduClazzVO;
import net.maku.edu.query.EduClazzQuery;
import net.maku.edu.entity.EduClazzEntity;
import net.maku.framework.mybatis.service.BaseService;

import java.util.List;

/**
 * 班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduClazzService extends BaseService<EduClazzEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduClazzVO> page(EduClazzQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduClazzVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduClazzVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
