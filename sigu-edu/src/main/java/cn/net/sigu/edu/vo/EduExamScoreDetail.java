package cn.net.sigu.edu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EduExamScoreDetail {

    @Schema(description = "学科id")
    private Long courseId;

    @Schema(description = "学科")
    private String courseName;

    @Schema(description = "学科成绩")
    private BigDecimal score;
}
