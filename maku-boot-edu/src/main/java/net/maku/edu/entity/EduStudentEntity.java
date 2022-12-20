package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("edu_student")
public class EduStudentEntity extends BaseEntity {

	/**
	* 学号
	*/
	private String no;

	/**
	* 姓名
	*/
	private String name;

	/**
	* 性别
	*/
	private String gender;

	/**
	* 班级id
	*/
	private Long clazzId;

	/**
	* 是否启用
	*/
	private Integer isEnabled;
}
