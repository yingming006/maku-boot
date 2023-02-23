package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 考试班级关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_exam_clazz")
public class EduExamClazzEntity {

	/**
	 * 考试id
	 */
	private Long examId;

	/**
	* 班级id
	*/
	private Long clazzId;

}
