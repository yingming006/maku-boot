package net.maku.edu.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.maku.framework.common.query.Query;

/**
* 考试学生信息查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-28
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Schema(description = "考试学生信息查询")
public class EduExamStudentQuery extends Query {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "考试id")
    @NotNull(message = "考试id不能为空")
    private Long examId;

    @Schema(description = "班级id")
    private Long clazzId;

    @Schema(description = "学生id")
    private Long studentId;
}
