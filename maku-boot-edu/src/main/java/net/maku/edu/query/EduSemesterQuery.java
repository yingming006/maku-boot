package net.maku.edu.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;

/**
* 学期信息表查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-19
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "学期信息表查询")
public class EduSemesterQuery extends Query {
}
