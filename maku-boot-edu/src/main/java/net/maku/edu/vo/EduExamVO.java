package net.maku.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;
import java.util.List;

/**
* 考试信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@Schema(description = "考试信息表")
public class EduExamVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "考试名称")
	private String name;

	@Schema(description = "考试类型")
	private String type;

	@Schema(description = "考试开始时间")
	@JsonFormat(pattern = DateUtils.DATE_PATTERN)
	private Date startDate;

	@Schema(description = "考试结束时间")
	@JsonFormat(pattern = DateUtils.DATE_PATTERN)
	private Date endDate;

	@Schema(description = "考试年级")
	private List<String> clazzList;

	@Schema(description = "考试课程")
	private List<String> courseList;

	@Schema(description = "备注")
	private String remark;

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
