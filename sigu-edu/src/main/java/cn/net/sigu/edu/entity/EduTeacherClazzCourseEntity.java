package cn.net.sigu.edu.entity;

import cn.net.sigu.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 教师_班级_课程关联表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("edu_teacher__clazz__course")
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

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
