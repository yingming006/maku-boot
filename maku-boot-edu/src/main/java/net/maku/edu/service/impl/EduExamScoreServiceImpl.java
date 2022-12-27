package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduExamScoreConvert;
import net.maku.edu.dao.EduExamScoreDao;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * 考试成绩表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduExamScoreServiceImpl extends BaseServiceImpl<EduExamScoreDao, EduExamScoreEntity> implements EduExamScoreService {

    @Override
    public PageResult<EduExamScoreVO> page(EduExamScoreQuery query) {

        List<EduExamScoreVO> stuList = baseMapper.selectList(getWrapper(query), query);

        List<EduExamScoreVO> result = new ArrayList<>();
        for (int i = 0; i < stuList.size();) {
            EduExamScoreVO vo = stuList.get(i);
            Long stuId = vo.getStudentId();
            LinkedHashMap<String, BigDecimal> scoreMap = new LinkedHashMap<>();
            while (scoreMap.isEmpty() || (i < stuList.size() && Objects.equals(stuList.get(i).getStudentId(), stuId))) {
                String courseName = "course_" + stuList.get(i).getCourseId();
                BigDecimal score = stuList.get(i).getScore();
                scoreMap.put(courseName, score);
                i++;
            }
            vo.setScoreList(scoreMap);
            result.add(vo);
        }
        return new PageResult<>(result, result.size());
    }

    private LambdaQueryWrapper<EduExamScoreEntity> getWrapper(EduExamScoreQuery query) {
        LambdaQueryWrapper<EduExamScoreEntity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(EduExamScoreVO vo) {
        EduExamScoreEntity entity = EduExamScoreConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduExamScoreVO vo) {
        EduExamScoreEntity entity = EduExamScoreConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
