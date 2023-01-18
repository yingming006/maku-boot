package cn.net.sigu.edu.entity;

import cn.net.sigu.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

/**
 * 学期信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-19
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_semester")
public class EduSemesterEntity extends BaseEntity {
	/**
	 * 标题
	 */
	private String name;

	/**
	* 学年
	*/
	private String year;

	/**
	* 学期
	*/
	private String semester;

	/**
	* 开始时间
	*/
	private Date startDate;

	/**
	* 结束时间
	*/
	private Date endDate;

	/**
	* 是否启用
	*/
	private Integer isEnabled;

}
