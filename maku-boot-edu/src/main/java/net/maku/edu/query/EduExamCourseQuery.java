package net.maku.edu.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;

/**
* 考试科目表查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-11
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "考试科目表查询")
public class EduExamCourseQuery extends Query {
}
