package net.maku.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
* 考试成绩表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@Schema(description = "考试成绩表")
public class EduExamScoreVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "考试id")
	private Long examId;

	@Schema(description = "学生id")
	private Long studentId;

	@Schema(description = "学生学号")
	private Long studentNo;

	@Schema(description = "学生姓名")
	private String studentName;

	@Schema(description = "班级id")
	private Long clazzId;

	@Schema(description = "课程id")
	private Long courseId;

	@Schema(description = "课程名称")
	private String courseName;

	@Schema(description = "成绩")
	private BigDecimal score;

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


