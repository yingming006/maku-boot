package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduExamCourseConvert;
import net.maku.edu.entity.EduExamCourseEntity;
import net.maku.edu.query.EduExamCourseQuery;
import net.maku.edu.vo.EduExamCourseVO;
import net.maku.edu.dao.EduExamCourseDao;
import net.maku.edu.service.EduExamCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 考试科目表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2023-01-11
 */
@Service
@AllArgsConstructor
public class EduExamCourseServiceImpl extends BaseServiceImpl<EduExamCourseDao, EduExamCourseEntity> implements EduExamCourseService {

    @Override
    public PageResult<EduExamCourseVO> page(EduExamCourseQuery query) {
        IPage<EduExamCourseEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduExamCourseConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduExamCourseEntity> getWrapper(EduExamCourseQuery query){
        LambdaQueryWrapper<EduExamCourseEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduExamCourseVO vo) {
        EduExamCourseEntity entity = EduExamCourseConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduExamCourseVO vo) {
        EduExamCourseEntity entity = EduExamCourseConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
