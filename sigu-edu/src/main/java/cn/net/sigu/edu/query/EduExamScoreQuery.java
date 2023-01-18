package cn.net.sigu.edu.query;

import cn.net.sigu.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
* 考试成绩表查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "考试成绩表查询")
public class EduExamScoreQuery extends Query {

    @Schema(description = "考试id")
    @NotNull(message = "考试id不能为空")
    private Long examId;

    @Schema(description = "班级id")
    private Long clazzId;

    @Schema(description = "学生id")
    private Long studentId;
}
