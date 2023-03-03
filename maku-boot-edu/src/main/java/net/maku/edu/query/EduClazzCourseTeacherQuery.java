package net.maku.edu.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.maku.framework.common.query.Query;

/**
 * 班级、课程、教师关联表查询
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-2-15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description = "班级、课程、教师关联表查询")
public class EduClazzCourseTeacherQuery extends Query {

    @Schema(description = "班级id")
    private Long clazzId;
}
