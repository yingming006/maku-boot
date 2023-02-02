package net.maku.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
* 考试学生信息
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-01-28
*/
@Data
@Schema(description = "考试学生信息")
public class EduExamStudentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "考试id")
	private Long examId;

	@Schema(description = "学生id")
	private Long studentId;

	@Schema(description = "准考证号")
	private Long examineeNo;

	@Schema(description = "总分")
	private BigDecimal totalScore;

	@Schema(description = "班级排名")
	private Integer clazzRank;

	@Schema(description = "年级排名")
	private Integer gradeRank;

	@Schema(description = "是否缺考")
	private Integer missed;

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
