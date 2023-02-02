package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

/**
 * 教师_班级_课程关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("edu_teacher_clazz_course")
public class EduTeacherClazzCourseEntity extends BaseEntity {
	/**
	* 教师id
	*/
	private Long teacherId;

	/**
	* 班级id
	*/
	private Long clazzId;

	/**
	* 课程id
	*/
	private Long courseId;

}
