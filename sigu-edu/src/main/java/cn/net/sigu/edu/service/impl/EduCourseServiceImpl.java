package cn.net.sigu.edu.service.impl;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduCourseConvert;
import cn.net.sigu.edu.entity.EduCourseEntity;
import cn.net.sigu.edu.query.EduCourseQuery;
import cn.net.sigu.edu.vo.EduCourseVO;
import cn.net.sigu.edu.dao.EduCourseDao;
import cn.net.sigu.edu.service.EduCourseService;
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
