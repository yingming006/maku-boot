package net.maku.edu.service;

import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.edu.vo.EduExamStudentVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.mybatis.service.BaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 考试学生信息
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-28
 */
public interface EduExamStudentService extends BaseService<EduExamStudentEntity> {

    /**
     * 分页
     * @param query
     * @return
     */
    PageResult<EduExamStudentScoreVO> page(EduExamStudentQuery query);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Result<EduExamStudentScoreVO> getById(Long id);

    /**
     * 保存
     * @param vo
     */
    void save(EduExamStudentVO vo);

    /**
     * 更新
     * @param vo
     */
    void update(EduExamStudentVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);

    /**
     * 修改成绩
     * @param vo
     */
    void updateScore(EduExamStudentScoreVO vo);

    /**
     * 导出模板
     * @param query
     */
    void exportTemplate(EduExamStudentQuery query);

    /**
     * 导入成绩
     * @param file
     * @param query
     */
    void importByExcel(MultipartFile file, EduExamStudentQuery query);

    /**
     * 查询考试学生列表，不查成绩
     * @param query
     * @return
     */
    PageResult<EduExamStudentScoreVO> pageWithoutScore(EduExamStudentQuery query);
}
