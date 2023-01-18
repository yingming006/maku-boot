package cn.net.sigu.edu.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.edu.vo.EduExamScoreVO;
import cn.net.sigu.edu.query.EduExamScoreQuery;
import cn.net.sigu.edu.entity.EduExamScoreEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamScoreService extends BaseService<EduExamScoreEntity> {

    /**
     * 查询考试学生列表，包括成绩
     * @param query
     * @return
     */
    PageResult<EduExamScoreVO> page(EduExamScoreQuery query);

    /**
     * 保存学生成绩
     * @param vo
     */
    void save(EduExamScoreVO vo);

    /**
     * 更新学生成绩
     * @param vo
     */
    void update(EduExamScoreVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);

    /**
     * 获取学生成绩
     * @param query
     * @return
     */
    EduExamScoreVO getByExamIdWithStuId(EduExamScoreQuery query);

    /**
     * 导出模板
     * @param query
     */
    void exportTemplate(EduExamScoreQuery query);

    /**
     * 导入成绩
     * @param file
     * @param query
     */
    void importByExcel(MultipartFile file, EduExamScoreQuery query);

    /**
     * 查询考试学生列表，不查成绩
     * @param query
     * @return
     */
    PageResult<EduExamScoreVO> pageWithoutScore(EduExamScoreQuery query);
}
