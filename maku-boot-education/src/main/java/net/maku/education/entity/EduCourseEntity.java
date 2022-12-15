package net.maku.education.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

/**
 * 课程信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_course")
public class EduCourseEntity extends BaseEntity {

	/**
	* 课程名称
	*/
	private String name;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
