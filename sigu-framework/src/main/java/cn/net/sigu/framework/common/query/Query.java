package cn.net.sigu.framework.common.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * 查询公共参数
 *
 * @author 阿沐 babamu@126.com
 */
@Data
public class Query {
    @Min(value = 1, message = "页码最小值为 1")
    @Schema(description = "当前页码", required = true)
    Integer page = 1;

    @Range(min = 1, max = Integer.MAX_VALUE, message = "每页条数超过最大范围")
    @Schema(description = "每页条数", required = true)
    Integer limit = 10;

    @Schema(description = "排序字段")
    String order;

    @Schema(description = "是否升序")
    boolean asc;

    @Schema(description = "是否进行 count 查询")
    boolean searchCount;
}
