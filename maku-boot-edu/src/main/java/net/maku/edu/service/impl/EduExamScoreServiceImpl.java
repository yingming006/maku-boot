package net.maku.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fhs.trans.service.impl.DictionaryTransService;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.*;
import net.maku.edu.dao.EduExamScoreDao;
import net.maku.edu.entity.EduExamEntity;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.listener.EduExamScoreListener;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.service.EduExamService;
import net.maku.edu.service.EduExamStudentService;
import net.maku.edu.vo.EduExamScoreDetail;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.edu.vo.EduExamVO;
import net.maku.framework.common.constant.Constant;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.common.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduExamScoreServiceImpl extends BaseServiceImpl<EduExamScoreDao, EduExamScoreEntity> implements EduExamScoreService {

    @Autowired
    private EduExamService eduExamService;

    @Autowired
    private DictionaryTransService dictionaryTransService;

    @Autowired
    private EduExamConvert eduExamConvert;

    private final String COURSE_PREFIX = "course_";

    @Override
    public PageResult<EduExamStudentScoreVO> page(EduExamScoreQuery query) {
//
        query.setSearchCount(false);
        List<EduExamScoreVO> stuList = baseMapper.selectAllList(getWrapper(query), query);
//
//        // 初始化成绩，默认为0
//        EduExamEntity entity = eduExamService.getById(query.getExamId());
//        EduExamVO examVO = eduExamConvert.convert(entity);
//        List<String> courseList = examVO.getCourseList();
//        LinkedHashMap<String, BigDecimal> scoreZeroMap = new LinkedHashMap<>();
//        for (String s : courseList) {
//            scoreZeroMap.put(COURSE_PREFIX + s, BigDecimal.ZERO);
//        }
//
//        // 为每位学生成绩赋值
//        List<EduExamStudentScoreVO> result = new ArrayList<>();
//        for (int i = 0; i < stuList.size(); ) {
//            EduExamScoreVO vo = stuList.get(i);
//            Long stuId = vo.getStudentId();
//            boolean isZero = true;
//            LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>(scoreZeroMap);
//            BigDecimal totalScore = BigDecimal.ZERO;
//            while (i < stuList.size() && Objects.equals(stuList.get(i).getStudentId(), stuId) && null != stuList.get(i).getScore()) {
//                String courseName = COURSE_PREFIX + stuList.get(i).getCourseId();
//                BigDecimal score = stuList.get(i).getScore();
//                scoreMap.put(courseName, score);
//                totalScore = totalScore.add(score);
//                i++;
//                isZero = false;
//            }
//
//            // 学生考试信息
//            EduExamStudentEntity examStudent = eduExamStudentService.getOne(new LambdaQueryWrapper<EduExamStudentEntity>()
//                    .eq(EduExamStudentEntity::getExamId, vo.getExamId())
//                    .eq(EduExamStudentEntity::getStudentId, vo.getStudentId())
//            );
//
//
//            if (isZero) {
//                i++;
//            }
//        }
//        return new PageResult<>(result, result.size());
        return null;
    }

    private LambdaQueryWrapper<EduExamScoreEntity> getWrapper(EduExamScoreQuery query) {
        LambdaQueryWrapper<EduExamScoreEntity> wrapper = Wrappers.lambdaQuery();
        // 默认学号升序
        if (StrUtil.isBlank(query.getOrder()) || StrUtil.equals(query.getOrder(), Constant.STUDENT_NO)) {
            query.setOrder(Constant.STUDENT_NO);
            query.setAsc(true);
        }
        return wrapper;
    }

    @Override
    public void save(EduExamScoreVO vo) {
        EduExamScoreEntity entity = EduExamScoreConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduExamStudentScoreVO vo) {

        // 获取该次考试考生所有成绩记录
        List<EduExamScoreEntity> entities = baseMapper.selectList(new QueryWrapper<EduExamScoreEntity>().lambda()
                .eq(EduExamScoreEntity::getExamId, vo.getExamId())
                .eq(EduExamScoreEntity::getStudentId, vo.getStudentId()));

        // 获取ids
        List<Long> ids = entities.stream().map(EduExamScoreEntity::getId).collect(Collectors.toList());

        // 删除旧纪录
        delete(ids);

        // 插入新成绩
        List<EduExamScoreDetail> details = vo.getScoreDetailList();
        for (EduExamScoreDetail detail : details) {
            EduExamScoreEntity entity = new EduExamScoreEntity();
            entity.setExamId(vo.getExamId());
            entity.setStudentId(vo.getStudentId());
            entity.setCourseId(detail.getCourseId());
            entity.setScore(detail.getScore());
            baseMapper.insert(entity);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public EduExamStudentScoreVO getByExamIdWithStuId(EduExamScoreQuery query) {
//        query.setSearchCount(false);
//        List<EduExamScoreVO> stuList = baseMapper.selectAllList(Wrappers.lambdaQuery(), query);
//
//        // 初始化成绩，默认为0
//        EduExamEntity entity = eduExamService.getById(query.getExamId());
//        EduExamVO examVO = eduExamConvert.convert(entity);
//        List<String> courseList = examVO.getCourseList();
//        LinkedHashMap<String, BigDecimal> scoreZeroMap = new LinkedHashMap<>();
//        for (String s : courseList) {
//            scoreZeroMap.put(COURSE_PREFIX + s, BigDecimal.ZERO);
//        }
//
//        LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>(scoreZeroMap);
//        BigDecimal totalScore = BigDecimal.ZERO;
//        for (EduExamScoreVO vo : stuList) {
//            if (null == vo.getCourseId()) {
//                continue;
//            }
//
//            String courseName = COURSE_PREFIX + vo.getCourseId();
//            BigDecimal score = vo.getScore();
//            scoreMap.put(courseName, score);
//            totalScore = totalScore.add(score);
//        }
//
//        EduExamScoreVO examScoreVO = stuList.get(0);
//
//        // 学生考试信息
//        EduExamStudentEntity examStudent = eduExamStudentService.getOne(new LambdaQueryWrapper<EduExamStudentEntity>()
//                .eq(EduExamStudentEntity::getExamId, examScoreVO.getExamId())
//                .eq(EduExamStudentEntity::getStudentId, examScoreVO.getStudentId())
//        );

        return null;
    }

    @Override
    public void exportTemplate(EduExamScoreQuery query) {
        EduExamEntity exam = eduExamService.getById(query.getExamId());
        if (query.getClazzId() != null) {
            // 附带班级学生
            ExcelUtils.excelExportNoModel(head(exam), exam.getName(), Constant.SHEET_DEFAULT, examScoreDataList(query));
        } else {
            ExcelUtils.excelExportNoModel(head(exam), exam.getName(), Constant.SHEET_DEFAULT, null);
        }

    }

    @Override
    public void importByExcel(MultipartFile file, EduExamScoreQuery query) {

        EduExamScoreListener listener = SpringUtil.getBean(EduExamScoreListener.class);
        listener.setExamId(query.getExamId());
        try {
            EasyExcel.read(file.getInputStream(), listener).sheet().doRead();
        } catch (IOException e) {
            throw new ServerException("导入失败" + e.getMessage());
        }
    }

    @Override
    public PageResult<EduExamStudentScoreVO> pageWithoutScore(EduExamScoreQuery query) {

//        query.setSearchCount(false);
//        List<EduExamScoreVO> stuList = baseMapper.selectAllList(getWrapper(query), query);
//
//        // 每位学生成绩为空
//        EduExamEntity entity = eduExamService.getById(query.getExamId());
//        EduExamVO examVO = eduExamConvert.convert(entity);
//        List<String> courseList = examVO.getCourseList();
//        LinkedHashMap<String, BigDecimal> scoreZeroMap = new LinkedHashMap<>();
//        for (String s : courseList) {
//            scoreZeroMap.put(COURSE_PREFIX + s, null);
//        }
//
//        // 先对结果去重，然后为每位学生赋值，排序
//        Set<EduExamScoreVO> stuSet = new TreeSet<>(Comparator.comparing(EduExamScoreVO::getStudentId));
//        stuSet.addAll(stuList);
//        List<EduExamScoreVO> scoreList = new ArrayList<>(stuSet);
//
//
//        List<EduExamStudentScoreVO> result = new ArrayList<>();
//        List<EduExamStudentScoreVO> finalResult = result;
//        scoreList.forEach(score-> {
//            // 学生考试信息
//            EduExamStudentEntity examStudent = eduExamStudentService.getOne(new LambdaQueryWrapper<EduExamStudentEntity>()
//                    .eq(EduExamStudentEntity::getExamId, score.getExamId())
//                    .eq(EduExamStudentEntity::getStudentId, score.getStudentId())
//            );
//
//        });
//        result = result.stream().sorted(Comparator.comparingLong(EduExamStudentScoreVO::getStudentNo)).collect(Collectors.toList());
//
//        return new PageResult<>(result, result.size());
        return null;
    }

    /**
     * 导出 excel 表头
     * @param entity
     * @return
     */
    private List<List<String>> head(EduExamEntity entity) {
        List<List<String>> list = ListUtils.newArrayList();
        List<String> head0 = ListUtils.newArrayList();
        head0.add("学生学号");
        List<String> head1 = ListUtils.newArrayList();
        head1.add("学生姓名");
        list.add(head0);
        list.add(head1);

        EduExamVO examVO = eduExamConvert.convert(entity);
        List<String> courseList = examVO.getCourseList();
        for (String s : courseList) {
            String courseName = dictionaryTransService.getDictionaryTransMap().get(Constant.COURSE_DICT_PREFIX + s);
            List<String> head = ListUtils.newArrayList(courseName);
            list.add(head);
        }

        return list;
    }

    /**
     * 获取考试班级学生列表
     * @param query
     * @return
     */
    private List<List<Object>> examScoreDataList(EduExamScoreQuery query) {
        List<List<Object>> list = ListUtils.newArrayList();
        List<EduExamStudentScoreVO> result = pageWithoutScore(query).getList();
        for (EduExamStudentScoreVO examStudentScoreVO : result) {
            List<Object> data = ListUtils.newArrayList();
            data.add(examStudentScoreVO.getStudentNo());
            data.add(examStudentScoreVO.getStudentName());
            list.add(data);
        }
        return list;
    }

    /**
     * 计算成绩排名
     */
    private void calcExamScoreRank(EduExamScoreQuery query, List<EduExamStudentScoreVO> list) {
        // TODO 排名
        List<EduExamStudentScoreVO> result = list.stream()
                .sorted(Comparator.comparing(EduExamStudentScoreVO::getTotalScore).reversed())
                .sorted(Comparator.comparing(EduExamStudentScoreVO::getStudentNo))
                .collect(Collectors.toList());

        AtomicInteger i = new AtomicInteger(1);
        result.forEach(score -> score.setClazzRank(i.getAndIncrement()));
    }
}
