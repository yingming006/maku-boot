package net.maku.education.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("edu_exam_score")
public class EduExamScoreEntity extends BaseEntity {

	/**
	* 考试id
	*/
	private Long examId;

	/**
	* 学生id
	*/
	private Long studentId;

	/**
	* 学生学号
	*/
	private String studentNo;

	/**
	* 学生姓名
	*/
	private String studentName;

	/**
	* 课程id
	*/
	private Long courseId;

	/**
	* 课程名称
	*/
	private String courseName;

	/**
	* 成绩
	*/
	private BigDecimal score;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
