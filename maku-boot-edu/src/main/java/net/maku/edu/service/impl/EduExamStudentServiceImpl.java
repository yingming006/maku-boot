package net.maku.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.vo.EduExamStudentScoreVO;
import net.maku.framework.common.constant.Constant;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduExamStudentConvert;
import net.maku.edu.entity.EduExamStudentEntity;
import net.maku.edu.query.EduExamStudentQuery;
import net.maku.edu.vo.EduExamStudentVO;
import net.maku.edu.dao.EduExamStudentDao;
import net.maku.edu.service.EduExamStudentService;
import net.maku.framework.common.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

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
    private EduExamScoreService eduExamScoreService;

    private final String COURSE_PREFIX = "course_";

    @Override
    public PageResult<EduExamStudentScoreVO> page(EduExamStudentQuery query) {
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

}
