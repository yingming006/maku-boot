package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduExamConvert;
import net.maku.edu.entity.EduExamEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.vo.EduExamVO;
import net.maku.edu.dao.EduExamDao;
import net.maku.edu.service.EduExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduExamServiceImpl extends BaseServiceImpl<EduExamDao, EduExamEntity> implements EduExamService {

    private final EduExamConvert eduExamConvert;

    @Override
    public PageResult<EduExamVO> page(EduExamQuery query) {
        IPage<EduExamEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(eduExamConvert.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduExamEntity> getWrapper(EduExamQuery query){
        LambdaQueryWrapper<EduExamEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public Long save(EduExamVO vo) {
        EduExamEntity entity = eduExamConvert.convert(vo);
        baseMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void update(EduExamVO vo) {
        EduExamEntity entity = eduExamConvert.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
