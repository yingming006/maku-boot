package cn.net.sigu.edu.entity;

import cn.net.sigu.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;

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
