package cn.net.sigu.edu.query;

import cn.net.sigu.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
