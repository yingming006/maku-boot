package net.maku.edu.vo;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
* 学期信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-19
*/
@Data
@Schema(description = "学期信息表")
public class EduSemesterVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "标题")
	private String name;

	@Schema(description = "学年")
	private String year;

	@Schema(description = "学期")
	private String semester;

	@Schema(description = "开始时间")
	@JsonFormat(pattern = DateUtils.DATE_PATTERN)
	@DateTimeFormat(value = DateUtils.DATE_PATTERN)
	private Date startDate;

	@Schema(description = "结束时间")
	@JsonFormat(pattern = DateUtils.DATE_PATTERN)
	@DateTimeFormat(value = DateUtils.DATE_PATTERN)
	private Date endDate;

	@Schema(description = "是否启用")
	private Integer isEnabled;

	@Schema(description = "是否删除")
	private Integer deleted;

	@Schema(description = "乐观锁")
	private Integer version;

	@Schema(description = "创建人")
	private Long creator;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "更新人")
	private Long updater;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;


}