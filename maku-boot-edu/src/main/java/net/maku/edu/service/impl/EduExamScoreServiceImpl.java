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
import net.maku.edu.convert.EduExamConvert;
import net.maku.edu.convert.EduExamScoreConvert;
import net.maku.edu.convert.EduTeacherConvert;
import net.maku.edu.dao.EduExamScoreDao;
import net.maku.edu.entity.EduExamEntity;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.listener.EduExamScoreListener;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.service.EduExamService;
import net.maku.edu.vo.EduExamScoreDetail;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.edu.vo.EduExamVO;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.common.utils.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
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

    private final EduExamService eduExamService;

    private final DictionaryTransService dictionaryTransService;

    private final EduExamConvert eduExamConvert;

    @Override
    public PageResult<EduExamScoreVO> page(EduExamScoreQuery query) {

        query.setSearchCount(false);
        List<EduExamScoreVO> stuList = baseMapper.selectAllList(getWrapper(query), query);

        // 初始化成绩，默认为0
        EduExamEntity entity = eduExamService.getById(query.getExamId());
        EduExamVO examVO = eduExamConvert.convert(entity);
        List<String> courseList = examVO.getCourseList();
        LinkedHashMap<String, BigDecimal> scoreZeroMap = new LinkedHashMap<>();
        for (String s : courseList) {
            scoreZeroMap.put("course_" + s, BigDecimal.ZERO);
        }

        // 为每位学生成绩赋值
        List<EduExamScoreVO> result = new ArrayList<>();
        for (int i = 0; i < stuList.size(); ) {
            EduExamScoreVO vo = stuList.get(i);
            Long stuId = vo.getStudentId();
            boolean isZero = true;
            LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>(scoreZeroMap);
            while (i < stuList.size() && Objects.equals(stuList.get(i).getStudentId(), stuId) && null != stuList.get(i).getScore()) {
                String courseName = "course_" + stuList.get(i).getCourseId();
                BigDecimal score = stuList.get(i).getScore();
                scoreMap.put(courseName, score);
                i++;
                isZero = false;
            }
            vo.setScoreList(scoreMap);
            result.add(vo);
            if (isZero) {
                i++;
            }
        }
        return new PageResult<>(result, result.size());
    }

    private LambdaQueryWrapper<EduExamScoreEntity> getWrapper(EduExamScoreQuery query) {
        LambdaQueryWrapper<EduExamScoreEntity> wrapper = Wrappers.lambdaQuery();
        // 默认学号升序
        if (StrUtil.isBlank(query.getOrder()) || StrUtil.equals(query.getOrder(), "student_no")) {
            query.setOrder(null);
            String lastSql = "order by length(student_no) " + (query.isAsc() ? "asc" : "desc") + ", student_no " + (query.isAsc() ? "asc" : "desc");
            wrapper.last(lastSql);
        }
        return wrapper;
    }

    @Override
    public void save(EduExamScoreVO vo) {
        EduExamScoreEntity entity = EduExamScoreConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduExamScoreVO vo) {

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
    public EduExamScoreVO getByExamIdWithStuId(EduExamScoreQuery query) {
        query.setSearchCount(false);
        List<EduExamScoreVO> stuList = baseMapper.selectAllList(Wrappers.lambdaQuery(), query);

        // 初始化成绩，默认为0
        EduExamEntity entity = eduExamService.getById(query.getExamId());
        EduExamVO examVO = eduExamConvert.convert(entity);
        List<String> courseList = examVO.getCourseList();
        LinkedHashMap<String, BigDecimal> scoreZeroMap = new LinkedHashMap<>();
        for (String s : courseList) {
            scoreZeroMap.put("course_" + s, BigDecimal.ZERO);
        }

        LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>(scoreZeroMap);
        for (EduExamScoreVO vo : stuList) {
            if (null == vo.getCourseId()) {
                continue;
            }

            String courseName = "course_" + vo.getCourseId();
            BigDecimal score = vo.getScore();
            scoreMap.put(courseName, score);
        }

        EduExamScoreVO result = stuList.get(0);
        result.setScoreList(scoreMap);
        result.setExamId(query.getExamId());

        return result;
    }

    @Override
    public void exportTemplate(EduExamScoreQuery query) {
        EduExamEntity exam = eduExamService.getById(query.getExamId());
        ExcelUtils.excelExportNoModel(head(exam), exam.getName(), "sheet1", null);
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
            String courseName = dictionaryTransService.getDictionaryTransMap().get("course_dict_" + s);
            List<String> head = ListUtils.newArrayList(courseName);
            list.add(head);
        }

        return list;
    }

}
