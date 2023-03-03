package net.maku.edu.service;

import net.maku.edu.vo.SysDictVO;
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

    /**
     * 字典数据
     * @param query
     * @return
     */
    List<SysDictVO.DictData> getDictData(EduClazzQuery query);

    /**
     * 通过id查询课程详情，包括开设课程
     * @param id
     * @return
     */
    EduClazzVO detail(Long id);

    /**
     * 修改开设课程
     * @param vo
     */
    void updateCourse(EduClazzVO vo);
}
