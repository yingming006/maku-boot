package net.maku.education.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

/**
 * 教师信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_teacher")
public class EduTeacherEntity extends BaseEntity {

	/**
	* 工号
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
	* 联系方式
	*/
	private String phone;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
