package net.maku.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
* 教师_班级_课程关联表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@Schema(description = "教师_班级_课程关联表")
public class EduTeacherClazzCourseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "教师id")
	private Long teacherId;

	@Schema(description = "班级id")
	private Long clazzId;

	@Schema(description = "课程id")
	private Long courseId;

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