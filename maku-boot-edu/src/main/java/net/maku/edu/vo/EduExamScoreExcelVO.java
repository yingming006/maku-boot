package net.maku.edu.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fhs.core.trans.vo.TransPojo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yingming006
 **/
@Data
public class EduExamScoreExcelVO implements Serializable, TransPojo {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private Long id;

    @Schema(description = "学生学号")
    private String studentNo;

    @Schema(description = "学生姓名")
    private String studentName;

}
