package net.maku.education.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.education.convert.EduExamScoreConvert;
import net.maku.education.entity.EduExamScoreEntity;
import net.maku.education.query.EduExamScoreQuery;
import net.maku.education.vo.EduExamScoreVO;
import net.maku.education.dao.EduExamScoreDao;
import net.maku.education.service.EduExamScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        IPage<EduExamScoreEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduExamScoreConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduExamScoreEntity> getWrapper(EduExamScoreQuery query){
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
