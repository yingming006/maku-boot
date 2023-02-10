package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.maku.framework.mybatis.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * 考试学生信息
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-28
 */
@Data
@Accessors(chain = true)
@TableName("edu_exam_student")
@EqualsAndHashCode(callSuper=false)
public class EduExamStudentEntity extends BaseEntity {

	/**
	* 考试id
	*/
	private Long examId;

	/**
	* 学生id
	*/
	private Long studentId;

	/**
	* 准考证号
	*/
	private Long examineeNo;

	/**
	 * 总分
	 */
	private BigDecimal totalScore;

	/**
	* 班级排名
	*/
	private Integer clazzRank;

	/**
	* 年级排名
	*/
	private Integer gradeRank;

	/**
	* 是否缺考
	*/
	private Integer missed;

}
