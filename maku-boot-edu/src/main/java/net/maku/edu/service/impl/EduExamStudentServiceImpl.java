package net.maku.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fhs.trans.service.impl.DictionaryTransService;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduExamConvert;
import net.maku.edu.convert.EduExamStudentConvert;
import net.maku.edu.dao.EduExamStudentDao;
import net.maku.edu.entity.EduExamEntity;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.listener.EduExamScoreListener;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.service.EduExamService;
import net.maku.edu.service.EduExamStudentService;
import net.maku.edu.vo.EduExamScoreDetail;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.edu.vo.EduExamStudentVO;
import net.maku.edu.vo.EduExamVO;
import net.maku.framework.common.constant.Constant;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 考试学生信息
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-28
 */
@Service
@AllArgsConstructor
public class EduExamStudentServiceImpl extends BaseServiceImpl<EduExamStudentDao, EduExamStudentEntity> implements EduExamStudentService {

    @Autowired
    private EduExamService eduExamService;

    @Autowired
    private EduExamScoreService eduExamScoreService;

    @Autowired
    private DictionaryTransService dictionaryTransService;

    @Autowired
    private EduExamConvert eduExamConvert;

    private final String COURSE_PREFIX = "course_";

    private final String SPLIT_CHAR = "\\.";

    @Override
    public PageResult<EduExamStudentScoreVO> page(EduExamStudentQuery query) {

        // 排序课程id
        String cId;
        if (StrUtil.isNotBlank(query.getOrder()) && query.getOrder().contains(SPLIT_CHAR)) {
            cId = query.getOrder().split(SPLIT_CHAR)[1];
            query.setOrder("");
            query.setAsc(false);
        } else {
            cId = "";
        }

        IPage<EduExamStudentScoreVO> page = baseMapper.selectAllList(getPage(query), getWrapper(query), query);

        List<EduExamStudentScoreVO> list = page.getRecords();

        list.forEach(vo -> {
            if (vo.getMissed() == null || vo.getMissed() != 1) {
                List<EduExamScoreEntity> scoreList = eduExamScoreService.list(new LambdaQueryWrapper<EduExamScoreEntity>()
                        .eq(EduExamScoreEntity::getExamId, vo.getExamId())
                        .eq(EduExamScoreEntity::getStudentId, vo.getStudentId())
                );

                LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>();
                for (EduExamScoreEntity scoreEntity : scoreList) {
                    String courseName = COURSE_PREFIX + scoreEntity.getCourseId();
                    BigDecimal score = scoreEntity.getScore();
                    scoreMap.put(courseName, score);
                }

                vo.setScoreList(scoreMap);
            }
        });

        if (StrUtil.isNotBlank(cId)) {
            list = list.stream().sorted((s1, s2) -> {
                if (s1.getScoreList().isEmpty() && s2.getScoreList().isEmpty()) {
                    return 0;
                } else if (!s1.getScoreList().isEmpty() && s2.getScoreList().isEmpty()) {
                    return 1;
                } else if (s1.getScoreList().isEmpty() && !s2.getScoreList().isEmpty()) {
                    return -1;
                } else {
                    return s1.getScoreList().get(cId).compareTo(s2.getScoreList().get(cId));
                }
            }).collect(Collectors.toList());
        }

        return new PageResult<>(list, 0);
    }

    @Override
    public Result<EduExamStudentScoreVO> getById(Long id) {

        EduExamStudentQuery query = new EduExamStudentQuery();
        query.setId(id);
        query.setSearchCount(false);
        IPage<EduExamStudentScoreVO> entity = baseMapper.selectAllList(getPage(query), getWrapper(query), query);

        if (entity.getRecords().isEmpty()) {
            throw new ServerException("找不到该学生考试信息");
        }

        EduExamStudentScoreVO result = new EduExamStudentScoreVO();

        BeanUtils.copyProperties(entity.getRecords().get(0), result);

        if (result.getMissed() == null || result.getMissed() != 1) {
            List<EduExamScoreEntity> scoreList = eduExamScoreService.list(new LambdaQueryWrapper<EduExamScoreEntity>()
                    .eq(EduExamScoreEntity::getExamId, result.getExamId())
                    .eq(EduExamScoreEntity::getStudentId, result.getStudentId())
            );

            LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>();
            for (EduExamScoreEntity scoreEntity : scoreList) {
                String courseName = COURSE_PREFIX + scoreEntity.getCourseId();
                BigDecimal score = scoreEntity.getScore();
                scoreMap.put(courseName, score);
            }

            result.setScoreList(scoreMap);
        }
        return Result.ok(result);
    }

    private LambdaQueryWrapper<EduExamStudentEntity> getWrapper(EduExamStudentQuery query) {
        LambdaQueryWrapper<EduExamStudentEntity> wrapper = Wrappers.lambdaQuery();

        // 默认学号升序
        if (StrUtil.isBlank(query.getOrder()) || StrUtil.equals(query.getOrder(), Constant.STUDENT_NO)) {
            query.setOrder(Constant.STUDENT_NO);
            query.setAsc(true);
        }

        return wrapper;
    }

    @Override
    public void save(EduExamStudentVO vo) {
        EduExamStudentEntity entity = EduExamStudentConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduExamStudentVO vo) {
        EduExamStudentEntity entity = EduExamStudentConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateScore(EduExamStudentScoreVO vo) {
        // 获取该次考试考生所有成绩记录
        List<EduExamScoreEntity> entities = eduExamScoreService.list(new QueryWrapper<EduExamScoreEntity>().lambda()
                .eq(EduExamScoreEntity::getExamId, vo.getExamId())
                .eq(EduExamScoreEntity::getStudentId, vo.getStudentId()));

        // 获取ids
        List<Long> ids = entities.stream().map(EduExamScoreEntity::getId).collect(Collectors.toList());

        // 删除旧纪录
        eduExamScoreService.delete(ids);

        // 插入新成绩
        List<EduExamScoreDetail> details = vo.getScoreDetailList();
        for (EduExamScoreDetail detail : details) {
            EduExamScoreEntity entity = new EduExamScoreEntity();
            entity.setExamId(vo.getExamId());
            entity.setStudentId(vo.getStudentId());
            entity.setCourseId(detail.getCourseId());
            entity.setScore(detail.getScore());
            eduExamScoreService.save(entity);
        }

        BigDecimal totalScore = details.stream().map(EduExamScoreDetail::getScore).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.update(new LambdaUpdateWrapper<EduExamStudentEntity>()
                .eq(EduExamStudentEntity::getId, vo.getId())
                .set(EduExamStudentEntity::getTotalScore, totalScore)
        );
    }

    @Override
    public void exportTemplate(EduExamStudentQuery query) {
        EduExamEntity exam = eduExamService.getById(query.getExamId());
        if (query.getClazzId() != null) {
            // 附带班级学生
            ExcelUtils.excelExportNoModel(head(exam), exam.getName(), Constant.SHEET_DEFAULT, examScoreDataList(query));
        } else {
            ExcelUtils.excelExportNoModel(head(exam), exam.getName(), Constant.SHEET_DEFAULT, null);
        }
    }

    @Override
    public void importByExcel(MultipartFile file, EduExamStudentQuery query) {
        EduExamScoreListener listener = SpringUtil.getBean(EduExamScoreListener.class);
        listener.setExamId(query.getExamId());
        try {
            EasyExcel.read(file.getInputStream(), listener).sheet().doRead();
        } catch (IOException e) {
            throw new ServerException("导入失败" + e.getMessage());
        }
    }

    @Override
    public PageResult<EduExamStudentScoreVO> pageWithoutScore(EduExamStudentQuery query) {
        query.setSearchCount(false);
        IPage<EduExamStudentScoreVO> page = baseMapper.selectAllList(getPage(query), getWrapper(query), query);

        List<EduExamStudentScoreVO> list = page.getRecords();
        list.forEach(vo -> {
            if (vo.getMissed() == null || vo.getMissed() != 1) {
                List<EduExamScoreEntity> scoreList = eduExamScoreService.list(new LambdaQueryWrapper<EduExamScoreEntity>()
                        .eq(EduExamScoreEntity::getExamId, vo.getExamId())
                        .eq(EduExamScoreEntity::getStudentId, vo.getStudentId())
                );

                LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>();
                for (EduExamScoreEntity scoreEntity : scoreList) {
                    String courseName = COURSE_PREFIX + scoreEntity.getCourseId();
                    BigDecimal score = scoreEntity.getScore();
                    scoreMap.put(courseName, score);
                }

                vo.setScoreList(scoreMap);
            }
        });


        return new PageResult<>(list, 0);
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
    private List<List<Object>> examScoreDataList(EduExamStudentQuery query) {
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

}
