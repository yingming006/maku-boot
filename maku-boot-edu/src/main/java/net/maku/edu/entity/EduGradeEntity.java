package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.mybatis.entity.BaseEntity;

/**
 * 年级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-20
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("edu_grade")
public class EduGradeEntity extends BaseEntity {

	/**
	* 年级
	*/
	private String name;

	/**
	* 阶段
	*/
	private String stage;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
