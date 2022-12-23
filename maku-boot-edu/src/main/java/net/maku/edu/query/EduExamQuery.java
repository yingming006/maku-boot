package net.maku.edu.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;

import javax.validation.constraints.NotNull;

/**
* 考试信息表查询
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "考试信息表查询")
public class EduExamQuery extends Query {

    @Schema(description = "考试id")
    private Long id;
}
