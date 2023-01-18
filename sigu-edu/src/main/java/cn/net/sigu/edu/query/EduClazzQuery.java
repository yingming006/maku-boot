package cn.net.sigu.edu.query;

import cn.net.sigu.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 班级信息表查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "班级信息表查询")
public class EduClazzQuery extends Query {
}
