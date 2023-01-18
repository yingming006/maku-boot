package cn.net.sigu.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduClazzConvert;
import cn.net.sigu.edu.dao.EduClazzDao;
import cn.net.sigu.edu.entity.EduClazzEntity;
import cn.net.sigu.edu.query.EduClazzQuery;
import cn.net.sigu.edu.service.EduClazzService;
import cn.net.sigu.edu.vo.EduClazzVO;
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
