package cn.net.sigu.edu.service.impl;

import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.query.EduExamQuery;
import cn.net.sigu.edu.convert.EduExamCourseConvert;
import cn.net.sigu.edu.entity.EduExamCourseEntity;
import cn.net.sigu.edu.vo.EduExamCourseVO;
import cn.net.sigu.edu.dao.EduExamCourseDao;
import cn.net.sigu.edu.service.EduExamCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<EduExamCourseEntity> list(EduExamQuery query) {
        if (null == query.getId()) {
            return new ArrayList<>();
        }
        return baseMapper.selectList(getWrapper(query));
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

    private LambdaQueryWrapper<EduExamCourseEntity> getWrapper(EduExamQuery query) {
        LambdaQueryWrapper<EduExamCourseEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(EduExamCourseEntity::getExamId, query.getId());
        return wrapper;
    }

}
