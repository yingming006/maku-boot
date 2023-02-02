package net.maku.edu.service;

import net.maku.edu.entity.EduSemesterEntity;
import net.maku.edu.query.EduSemesterQuery;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.edu.vo.EduSemesterVO;

import java.util.List;

/**
 * 学期信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-19
 */
public interface EduSemesterService extends BaseService<EduSemesterEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduSemesterVO> page(EduSemesterQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(EduSemesterVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduSemesterVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);
}
