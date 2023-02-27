package net.maku.framework.common.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 查询公共参数
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class Query {
    @Min(value = 1, message = "页码最小值为 1")
    @Schema(description = "当前页码")
    Integer page = 1;

    @Range(min = 1, max = Integer.MAX_VALUE, message = "每页条数，取值范围 1-1000")
    @Schema(description = "每页条数")
    Integer limit = 10;

    @Schema(description = "排序字段")
    String order;

    @Schema(description = "是否升序")
    boolean asc;

    @Schema(description = "是否进行 count 查询")
    boolean searchCount;
}
