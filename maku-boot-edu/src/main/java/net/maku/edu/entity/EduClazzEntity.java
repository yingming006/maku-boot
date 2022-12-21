package net.maku.edu.entity;

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
	 * 行政班级
	 */
	private String name;

	/**
	 * 入学年份
	 */
	private Integer entranceYear;

	/**
	* 年级id
	*/
	private Long gradeId;

	/**
	 * 学期id
	 */
	private Long semesterId;

	/**
	 * 班主任id
	 */
	private Long headmasterId;

	/**
	* 是否启用
	*/
	private Integer isEnabled;
}
