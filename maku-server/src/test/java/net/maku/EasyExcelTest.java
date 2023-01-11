package net.maku;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import net.maku.edu.listener.EduExamScoreListener;
import net.maku.framework.common.excel.DateConverter;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import net.maku.framework.common.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * EasyExcel 测试
 *
 * @author eden
 */
@SpringBootTest
public class EasyExcelTest {

    @Test
    public void doImport() {
        File file = new File("D://upload//test01.xlsx");
        ExcelClass excelClass = new ExcelClass();
        excelClass.setNumber(1);
        excelClass.setDecimals(1.2);
        excelClass.setString("test");
        excelClass.setDate(new Date());
        List<ExcelClass> data = Arrays.asList(excelClass, excelClass, excelClass);
        if (file.exists()) {
            ExcelUtils.excelExport(ExcelClass.class, file, data);
            List<ExcelClass> list = ExcelUtils.readSync(file, ExcelClass.class);
            list.forEach(System.out::println);
        }
    }


    @Test
    public void doAImport() {
        File file = new File("D://1.xlsx");
        ExcelClass excelClass = new ExcelClass();
        excelClass.setNumber(1);
        excelClass.setDecimals(1.2);
        excelClass.setString("test");
        excelClass.setDate(new Date());
        List<ExcelClass> data = Arrays.asList(excelClass, excelClass, excelClass, excelClass, excelClass, excelClass, excelClass);
        if (file.exists()) {
            ExcelUtils.excelExport(ExcelClass.class, file, data);
            ExcelUtils.readAnalysis(file, ExcelClass.class, new ServiceA());
        }

    }

    /**
     * 不创建对象的读
     */
    @Test
    public void noModelRead() {
        String fileName = "D://1.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish

        EduExamScoreListener listener = SpringUtil.getBean(EduExamScoreListener.class);
        listener.setExamId(7L);
        EasyExcel.read(fileName, listener).sheet().doRead();
    }

    @Data
    public static class ExcelClass {

        @ExcelProperty("整数")
        private Integer number;

        @ExcelProperty("字符串")
        private String string;

        @ExcelProperty("小数")
        private Double decimals;

        @ExcelProperty(value = "日期", converter = DateConverter.class)
        private Date date;
    }

}

class ServiceA implements ExcelFinishCallBack<EasyExcelTest.ExcelClass> {

    @Override
    public void doAfterAllAnalysed(List<EasyExcelTest.ExcelClass> result) {
        System.out.println(result.size());
    }
}
