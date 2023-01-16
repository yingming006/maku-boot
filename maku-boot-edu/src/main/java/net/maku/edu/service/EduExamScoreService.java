package net.maku.edu.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.entity.EduExamScoreEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
public interface EduExamScoreService extends BaseService<EduExamScoreEntity> {

    PageResult<EduExamScoreVO> page(EduExamScoreQuery query);

    void save(EduExamScoreVO vo);

    void update(EduExamScoreVO vo);

    void delete(List<Long> idList);

    EduExamScoreVO getByExamIdWithStuId(EduExamScoreQuery query);

    void exportTemplate(EduExamScoreQuery query);

    void importByExcel(MultipartFile file, EduExamScoreQuery query);

    PageResult<EduExamScoreVO> pageWithoutScore(EduExamScoreQuery query);
}
