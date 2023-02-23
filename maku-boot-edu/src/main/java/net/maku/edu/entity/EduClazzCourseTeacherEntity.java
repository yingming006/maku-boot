package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 班级课程教师关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-2-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_clazz_course_teacher")
public class EduClazzCourseTeacherEntity {

	/**
	* 班级id
	*/
	private Long clazzId;

	/**
	 * 课程id
	 */
	private Long courseId;

	/**
	 * 教师id
	 */
	private Long teacherId;
}
