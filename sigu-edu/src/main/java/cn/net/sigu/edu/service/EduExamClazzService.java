package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.entity.EduExamClazzEntity;
import cn.net.sigu.edu.query.EduExamQuery;

import java.util.List;

/**
 * 考试班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamClazzService extends BaseService<EduExamClazzEntity> {

    /**
     * 查询考试班级列表
     * @param query
     * @return
     */
    List<EduExamClazzEntity> list(EduExamQuery query);
}
