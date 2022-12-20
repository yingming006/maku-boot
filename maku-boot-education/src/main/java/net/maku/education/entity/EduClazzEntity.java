package net.maku.education.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

/**
 * 班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_clazz")
public class EduClazzEntity extends BaseEntity {

	/**
	* 年级
	*/
	private String grade;

	/**
	* 班级
	*/
	private String clazz;

	/**
	 * 班主任id
	 */
	private Long headmasterId;

	/**
	 * 班主任
	 */
	private String headmaster;

	/**
	* 是否启用
	*/
	private Integer isEnabled;
}
