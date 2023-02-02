package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * 考试科目表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-11
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("edu_exam_course")
public class EduExamCourseEntity extends BaseEntity {

	/**
	* 考试id
	*/
	private Long examId;

	/**
	* 课程id
	*/
	private Long courseId;

	/**
	* 满分成绩
	*/
	private Integer fullScore;

}
