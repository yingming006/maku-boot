package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import net.maku.edu.dao.EduClazzCourseTeacherDao;
import net.maku.edu.entity.EduClazzCourseTeacherEntity;
import net.maku.edu.query.EduClazzCourseTeacherQuery;
import net.maku.edu.service.EduClazzCourseTeacherService;
import net.maku.edu.vo.EduClazzCourseTeacherVO;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduClazzCourseTeacherServiceImpl extends BaseServiceImpl<EduClazzCourseTeacherDao, EduClazzCourseTeacherEntity> implements EduClazzCourseTeacherService {

    @Override
    public List<EduClazzCourseTeacherVO> list(EduClazzCourseTeacherQuery query) {

        QueryWrapper<EduClazzCourseTeacherQuery> wrapper = Wrappers.query();
        wrapper.eq(query.getClazzId()!= null, "clazz_id", query.getClazzId());
        return baseMapper.list(wrapper);
    }
}
