package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.edu.dao.EduExamClazzDao;
import net.maku.edu.entity.EduExamClazzEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.service.EduExamClazzService;
import net.maku.edu.vo.EduExamClazzVO;
import net.maku.edu.vo.EduExamVO;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public EduExamClazzVO selectIds(EduExamQuery query) {

        EduExamClazzVO result = new EduExamClazzVO();

        if (query.getId() == null) {
            return result;
        }

        List<EduExamClazzEntity> entities = baseMapper.selectList(new LambdaQueryWrapper<EduExamClazzEntity>().eq(EduExamClazzEntity::getExamId, query.getId()));

        List<EduExamClazzVO> list = baseMapper.selectIds(query);


        List<Long> gradeIds = list.stream().map(EduExamClazzVO::getGradeId).distinct().toList();
        List<Long> clazzIds = list.stream().map(EduExamClazzVO::getClazzId).distinct().toList();

        result.setGradeIds(gradeIds);
        result.setClazzIds(clazzIds);

        return result;
    }


    private LambdaQueryWrapper<EduExamClazzEntity> getWrapper(EduExamQuery query) {
        LambdaQueryWrapper<EduExamClazzEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(EduExamClazzEntity::getExamId, query.getId());
        return wrapper;
    }

}
