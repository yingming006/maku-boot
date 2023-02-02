package net.maku.edu.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.edu.vo.EduTeacherVO;
import net.maku.edu.query.EduTeacherQuery;
import net.maku.edu.entity.EduTeacherEntity;

import java.util.List;

/**
 * 教师信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduTeacherService extends BaseService<EduTeacherEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduTeacherVO> page(EduTeacherQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduTeacherVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduTeacherVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
