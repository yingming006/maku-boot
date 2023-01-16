package net.maku;

import cn.hutool.core.util.RandomUtil;
import net.maku.edu.entity.EduClazzEntity;
import net.maku.edu.entity.EduStudentEntity;
import net.maku.edu.service.EduClazzService;
import net.maku.edu.service.EduStudentService;
import net.maku.framework.common.utils.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * EduStudentController 测试类
 *
 * @author yingming006
 */
@SpringBootTest
public class EduStudentControllerTest {


    @Autowired
    private EduClazzService eduClazzService;

    @Autowired
    private EduStudentService eduStudentService;


    /**
     * 填充数据
     */
    @Test
    public void generate() {

        List<EduClazzEntity> clazzList = eduClazzService.list();

        List<EduStudentEntity> stuList = new ArrayList<>();
        for (EduClazzEntity clazzEntity : clazzList) {
            for (int i = 0; i < 10; i++) {
                EduStudentEntity entity = new EduStudentEntity();
                entity.setNo(Long.valueOf(RandomUtil.randomNumbers(10)));
                entity.setName(RandomUtils.randomChinese(RandomUtil.randomInt(2, 4)));
                entity.setGender(String.valueOf(RandomUtil.randomInt(2)));
                entity.setClazzId(clazzEntity.getId());
                stuList.add(entity);
            }
        }
        eduStudentService.saveBatch(stuList);
    }
}
