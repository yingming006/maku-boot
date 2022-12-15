package net.maku.education.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;

/**
* 教师_班级_课程关联表查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "教师_班级_课程关联表查询")
public class EduTeacherClazzCourseQuery extends Query {
}
