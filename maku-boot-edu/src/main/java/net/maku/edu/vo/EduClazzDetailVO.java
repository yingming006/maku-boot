package net.maku.edu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import net.maku.framework.common.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 班级信息详情 开设课程、授课老师
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@Schema(description = "班级信息表")
public class EduClazzDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "班级id")
	private String clazzId;

	@Schema(description = "班级")
	private String clazzName;

	@Schema(description = "课程id")
	private String courseId;

	@Schema(description = "课程名称")
	private String courseName;

	@Schema(description = "教师id")
	private String teacherId;

	@Schema(description = "教师姓名")
	private String teacherName;
}
