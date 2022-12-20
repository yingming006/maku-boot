package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduGradeConvert;
import net.maku.edu.entity.EduGradeEntity;
import net.maku.edu.query.EduGradeQuery;
import net.maku.edu.vo.EduGradeVO;
import net.maku.edu.dao.EduGradeDao;
import net.maku.edu.service.EduGradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 年级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-20
 */
@Service
@AllArgsConstructor
public class EduGradeServiceImpl extends BaseServiceImpl<EduGradeDao, EduGradeEntity> implements EduGradeService {

    @Override
    public PageResult<EduGradeVO> page(EduGradeQuery query) {
        IPage<EduGradeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduGradeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduGradeEntity> getWrapper(EduGradeQuery query){
        LambdaQueryWrapper<EduGradeEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduGradeVO vo) {
        EduGradeEntity entity = EduGradeConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduGradeVO vo) {
        EduGradeEntity entity = EduGradeConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}