package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduExamScoreConvert;
import net.maku.edu.dao.EduExamScoreDao;
import net.maku.edu.entity.EduExamScoreEntity;
import net.maku.edu.query.EduExamScoreQuery;
import net.maku.edu.service.EduExamScoreService;
import net.maku.edu.vo.EduExamScoreVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EduExamScoreConvert eduExamScoreConvert;

    @Override
    public PageResult<EduExamScoreVO> page(EduExamScoreQuery query) {
        IPage<EduExamScoreEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(eduExamScoreConvert.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduExamScoreEntity> getWrapper(EduExamScoreQuery query) {
        LambdaQueryWrapper<EduExamScoreEntity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(EduExamScoreVO vo) {
        EduExamScoreEntity entity = eduExamScoreConvert.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduExamScoreVO vo) {
        EduExamScoreEntity entity = eduExamScoreConvert.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
