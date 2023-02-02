package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduTeacherConvert;
import net.maku.edu.entity.EduTeacherEntity;
import net.maku.edu.query.EduTeacherQuery;
import net.maku.edu.vo.EduTeacherVO;
import net.maku.edu.dao.EduTeacherDao;
import net.maku.edu.service.EduTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 教师信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduTeacherServiceImpl extends BaseServiceImpl<EduTeacherDao, EduTeacherEntity> implements EduTeacherService {

    @Override
    public PageResult<EduTeacherVO> page(EduTeacherQuery query) {
        IPage<EduTeacherEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduTeacherConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduTeacherEntity> getWrapper(EduTeacherQuery query){
        LambdaQueryWrapper<EduTeacherEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduTeacherVO vo) {
        EduTeacherEntity entity = EduTeacherConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduTeacherVO vo) {
        EduTeacherEntity entity = EduTeacherConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
