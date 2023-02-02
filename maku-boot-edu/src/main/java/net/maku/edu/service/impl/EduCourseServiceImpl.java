package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduCourseConvert;
import net.maku.edu.entity.EduCourseEntity;
import net.maku.edu.query.EduCourseQuery;
import net.maku.edu.vo.EduCourseVO;
import net.maku.edu.dao.EduCourseDao;
import net.maku.edu.service.EduCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduCourseServiceImpl extends BaseServiceImpl<EduCourseDao, EduCourseEntity> implements EduCourseService {

    @Override
    public PageResult<EduCourseVO> page(EduCourseQuery query) {
        IPage<EduCourseEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduCourseConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduCourseEntity> getWrapper(EduCourseQuery query){
        LambdaQueryWrapper<EduCourseEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduCourseVO vo) {
        EduCourseEntity entity = EduCourseConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduCourseVO vo) {
        EduCourseEntity entity = EduCourseConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
