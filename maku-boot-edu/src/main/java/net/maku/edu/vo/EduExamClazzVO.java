package net.maku.edu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.maku.framework.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 考试班级信息VO
*
* @author yingming006 yingming006@foxmail.com
* @since 1.0.0 2023-02-11
*/
@Data
@Schema(description = "考试班级信息VO")
public class EduExamClazzVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "考试id")
	private Long examId;

	@Schema(description = "班级id")
	private Long clazzId;

	@Schema(description = "年级id")
	private Long gradeId;

	@Schema(description = "clazzIds")
	private List<Long> clazzIds;

	@Schema(description = "gradeIds")
	private List<Long> gradeIds;

}
