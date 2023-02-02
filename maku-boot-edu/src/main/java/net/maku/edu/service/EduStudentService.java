package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.edu.vo.EduStudentVO;
import net.maku.edu.query.EduStudentQuery;
import net.maku.edu.entity.EduStudentEntity;

import java.util.List;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduStudentService extends BaseService<EduStudentEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduStudentVO> page(EduStudentQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduStudentVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduStudentVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
