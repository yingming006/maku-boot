package net.maku.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
* 学生考试成绩
*/
@Data
@Schema(description = "学生考试成绩")
public class EduExamStudentScoreVO implements Serializable {
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

	@Schema(description = "是否缺考")
	private Integer missed;

	@Schema(description = "是否删除")
	private Integer deleted;

	@Schema(description = "乐观锁")
	private Integer version;

	@Schema(description = "成绩，查询结果")
	private LinkedHashMap<String, BigDecimal> scoreList;

	@Schema(description = "个人成绩，修改用")
	private List<EduExamScoreDetail> scoreDetailList;

	@Schema(description = "总分")
	private BigDecimal totalScore;

	@Schema(description = "班级排名")
	private Integer clazzRank;

	@Schema(description = "年级排名")
	private Integer gradeRank;
}


