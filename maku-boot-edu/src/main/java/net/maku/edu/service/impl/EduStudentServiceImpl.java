package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.edu.convert.EduStudentConvert;
import net.maku.edu.entity.EduStudentEntity;
import net.maku.edu.query.EduStudentQuery;
import net.maku.edu.vo.EduStudentVO;
import net.maku.edu.dao.EduStudentDao;
import net.maku.edu.service.EduStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学生信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduStudentServiceImpl extends BaseServiceImpl<EduStudentDao, EduStudentEntity> implements EduStudentService {

    @Override
    public PageResult<EduStudentVO> page(EduStudentQuery query) {
        IPage<EduStudentVO> page = baseMapper.selectListPage(getPage(query), getWrapper(query));
        Long total = baseMapper.selectCount(getWrapper(query));

        return new PageResult<>(page.getRecords(), total);
    }

    private LambdaQueryWrapper<EduStudentEntity> getWrapper(EduStudentQuery query) {
        LambdaQueryWrapper<EduStudentEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduStudentVO vo) {
        EduStudentEntity entity = EduStudentConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(EduStudentVO vo) {
        EduStudentEntity entity = EduStudentConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}
