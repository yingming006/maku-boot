package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.edu.dao.EduExamClazzDao;
import net.maku.edu.entity.EduExamClazzEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.service.EduExamClazzService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 考试班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduExamClazzServiceImpl extends BaseServiceImpl<EduExamClazzDao, EduExamClazzEntity> implements EduExamClazzService {

    @Override
    public List<EduExamClazzEntity> list(EduExamQuery query) {
        if (null == query.getId()) {
            return new ArrayList<>();
        }
        return baseMapper.selectList(getWrapper(query));
    }


    private LambdaQueryWrapper<EduExamClazzEntity> getWrapper(EduExamQuery query) {
        LambdaQueryWrapper<EduExamClazzEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(EduExamClazzEntity::getExamId, query.getId());
        return wrapper;
    }

}
