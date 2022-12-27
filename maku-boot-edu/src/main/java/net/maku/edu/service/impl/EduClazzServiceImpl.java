package net.maku.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduClazzConvert;
import net.maku.edu.dao.EduClazzDao;
import net.maku.edu.entity.EduClazzEntity;
import net.maku.edu.query.EduClazzQuery;
import net.maku.edu.service.EduClazzService;
import net.maku.edu.service.EduGradeService;
import net.maku.edu.service.EduSemesterService;
import net.maku.edu.service.EduTeacherService;
import net.maku.edu.vo.EduClazzVO;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 班级信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduClazzServiceImpl extends BaseServiceImpl<EduClazzDao, EduClazzEntity> implements EduClazzService {

    @Override
    public PageResult<EduClazzVO> page(EduClazzQuery query) {
        IPage<EduClazzEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(EduClazzConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduClazzEntity> getWrapper(EduClazzQuery query) {
        LambdaQueryWrapper<EduClazzEntity> wrapper = Wrappers.lambdaQuery();
        if (StrUtil.isBlank(query.getOrder())) {
            wrapper.orderByDesc(EduClazzEntity::getEntranceYear);
        }
        return wrapper;
    }

    @Override
    public void save(EduClazzVO vo) {
        EduClazzEntity entity = EduClazzConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(EduClazzVO vo) {
        EduClazzEntity entity = EduClazzConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}