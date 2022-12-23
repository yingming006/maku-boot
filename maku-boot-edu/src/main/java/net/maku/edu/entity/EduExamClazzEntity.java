package net.maku.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

import java.util.Date;

/**
 * 考试班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_exam_clazz")
public class EduExamClazzEntity {

	/**
	 * 考试id
	 */
	private Long examId;

	/**
	* 考试年级
	*/
	private Long clazzId;

}
