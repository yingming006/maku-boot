package net.maku.edu.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import net.maku.framework.common.entity.BaseEntity;

import java.util.Date;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_exam")
public class EduExamEntity extends BaseEntity {

	/**
	* 考试名称
	*/
	private String name;

	/**
	* 考试类型
	*/
	private String type;

	/**
	* 考试开始时间
	*/
	private Date startTime;

	/**
	* 考试结束时间
	*/
	private Date endTime;

	/**
	* 考试年级
	*/
	private Long clazzId;

	/**
	* 备注
	*/
	private String remark;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
