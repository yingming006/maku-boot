package net.maku.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
* 学生考试成绩
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "学生考试成绩")
public class EduExamStudentScoreVO extends EduExamStudentVO implements Serializable {
	@Schema(description = "成绩，查询结果")
	private LinkedHashMap<String, BigDecimal> scoreList;

	@Schema(description = "个人成绩，修改用")
	private List<EduExamScoreDetail> scoreDetailList;
}


