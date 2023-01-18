package cn.net.sigu.edu.service.impl;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduGradeConvert;
import cn.net.sigu.edu.entity.EduGradeEntity;
import cn.net.sigu.edu.query.EduGradeQuery;
import cn.net.sigu.edu.vo.EduGradeVO;
import cn.net.sigu.edu.dao.EduGradeDao;
import cn.net.sigu.edu.service.EduGradeService;
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