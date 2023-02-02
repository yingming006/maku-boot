package net.maku.edu.listener;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fhs.trans.service.impl.DictionaryTransService;
import lombok.Setter;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.entity.EduStudentEntity;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.service.EduExamStudentService;
import net.maku.edu.service.EduStudentService;
import net.maku.framework.common.constant.Constant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yingming006
 **/
@Component
@Setter
public class EduExamScoreListener extends AnalysisEventListener<Map<Integer, String>> {


    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    private List<Map<Integer, String>> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private Map<Integer, String> headMap;

    private final EduExamScoreService eduExamScoreService;
    private final EduExamStudentService eduExamStudentService;
    private final EduStudentService eduStudentService;

    private Long examId;

    public EduExamScoreListener(EduExamScoreService eduExamScoreService, EduExamStudentService eduExamStudentService, EduStudentService eduStudentService) {
        this.eduExamScoreService = eduExamScoreService;
        this.eduExamStudentService = eduExamStudentService;
        this.eduStudentService = eduStudentService;
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {

        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 这里会一行行的返回头
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.headMap = headMap;
        initHeadMap();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 保存成绩表
        saveData();
        // 计算成绩
        calcScore();
    }

    /**
     * 计算总成绩
     */
    private void calcScore() {
        List<EduExamStudentEntity> list = eduExamStudentService.list(new LambdaQueryWrapper<EduExamStudentEntity>().eq(EduExamStudentEntity::getExamId, this.examId));

        list.forEach(entity -> {
            List<EduExamScoreEntity> scores = eduExamScoreService.list(new LambdaQueryWrapper<EduExamScoreEntity>().eq(EduExamScoreEntity::getExamId, entity.getExamId()).eq(EduExamScoreEntity::getStudentId, entity.getStudentId()));
            BigDecimal totalScore = scores.stream().map(EduExamScoreEntity::getScore).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
            entity.setTotalScore(totalScore);
        });

        eduExamStudentService.updateBatchById(list);
    }

    private void initHeadMap() {
        DictionaryTransService dictionaryTransService = SpringUtil.getBean(DictionaryTransService.class);
        // 查询课程字典，翻译
        for (int i = 2; i < headMap.size(); i++) {
            headMap.put(i, dictionaryTransService.getUnTransMap().get(Constant.COURSE_DICT_PREFIX + headMap.get(i)));
        }
    }

    /**
     * 保存成绩表
     */
    private void saveData() {

        List<EduExamScoreEntity> list = new ArrayList<>();
        for (Map<Integer, String> map : cachedDataList) {

            // 通过学号获取学生信息
            EduStudentEntity student = eduStudentService.getOne(new LambdaQueryWrapper<EduStudentEntity>().eq(EduStudentEntity::getNo, map.get(0)));

            for (int i = 2; i < headMap.size(); i++) {
                if (null == headMap.get(i)) {
                    continue;
                }
                EduExamScoreEntity entity = eduExamScoreService.getOne(new LambdaQueryWrapper<EduExamScoreEntity>().eq(EduExamScoreEntity::getExamId, this.examId).eq(EduExamScoreEntity::getStudentId, student.getId()).eq(EduExamScoreEntity::getCourseId, Long.valueOf(headMap.get(i))));
                EduExamScoreEntity newEntity = new EduExamScoreEntity();
                if (null != entity) {
                    newEntity.setId(entity.getId());
                }
                newEntity.setExamId(this.examId);
                newEntity.setStudentId(student.getId());
                newEntity.setCourseId(Long.valueOf(headMap.get(i)));
                if (map.get(i) != null) {
                    newEntity.setScore(new BigDecimal(map.get(i)));
                } else {
                    newEntity.setScore(null);
                }
                list.add(newEntity);
            }
        }
        eduExamScoreService.saveOrUpdateBatch(list);
    }
}
