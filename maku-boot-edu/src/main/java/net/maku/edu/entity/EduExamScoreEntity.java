package net.maku.edu.entity;

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
	 * 准考证号
	 */
	private Long examineeNo;

	/**
	* 考试id
	*/
	private Long examId;

	/**
	* 学生id
	*/
	private Long studentId;

	/**
	* 课程id
	*/
	private Long courseId;

	/**
	* 成绩
	*/
	private BigDecimal score;

	/**
	 * 是否缺考
	 */
	private Integer missed;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
