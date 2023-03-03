package net.maku.edu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.maku.framework.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 班级信息表
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2022-12-15
*/
@Data
@Schema(description = "班级信息表")
public class EduClazzVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "班级编号")
	private Long no;

	@Schema(description = "行政班级")
	private String name;

	@Schema(description = "入学年份")
	private String entranceYear;

	@Schema(description = "年级id")
	private String gradeId;

	@Schema(description = "年级")
	private String gradeName;

	@Schema(description = "学期id")
	private String semesterId;

	@Schema(description = "学期")
	private String semesterName;

	@Schema(description = "班主任id")
	private String headmasterId;

	@Schema(description = "班主任")
	private String headmaster;

	@Schema(description = "开设课程及授课老师")
	private List<EduClazzCourseTeacherVO> details;

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
