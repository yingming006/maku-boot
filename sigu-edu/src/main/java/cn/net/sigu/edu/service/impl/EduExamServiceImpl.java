package cn.net.sigu.edu.service.impl;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import cn.net.sigu.edu.convert.EduExamConvert;
import cn.net.sigu.edu.dao.EduExamDao;
import cn.net.sigu.edu.entity.EduExamClazzEntity;
import cn.net.sigu.edu.entity.EduExamCourseEntity;
import cn.net.sigu.edu.entity.EduExamEntity;
import cn.net.sigu.edu.query.EduExamQuery;
import cn.net.sigu.edu.service.EduExamClazzService;
import cn.net.sigu.edu.service.EduExamCourseService;
import cn.net.sigu.edu.service.EduExamService;
import cn.net.sigu.edu.vo.EduExamVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduExamServiceImpl extends BaseServiceImpl<EduExamDao, EduExamEntity> implements EduExamService {

    private final EduExamConvert eduExamConvert;

    private final EduExamClazzService eduExamClazzService;

    private final EduExamCourseService eduExamCourseService;

    @Override
    public PageResult<EduExamVO> page(EduExamQuery query) {
        IPage<EduExamEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(eduExamConvert.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<EduExamEntity> getWrapper(EduExamQuery query){
        LambdaQueryWrapper<EduExamEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(EduExamVO vo) {
        EduExamEntity entity = eduExamConvert.convert(vo);
        baseMapper.insert(entity);

        vo.setId(entity.getId());

        // 保存考试班级、考试科目
        saveEduExamClazz(vo);
        saveEduExamCourse(vo);
    }

    /**
     * 保存考试科目
     * @param vo
     */
    private void saveEduExamCourse(EduExamVO vo) {
        List<String> courseList = vo.getCourseList();
        List<String> courseFullScoreList = vo.getCourseFullScoreList();
        if (!courseList.isEmpty() && !courseFullScoreList.isEmpty()) {
            List<EduExamCourseEntity> courseEntities = new ArrayList<>();
            for (int i = 0; i < courseList.size(); i++) {
                EduExamCourseEntity courseEntity = new EduExamCourseEntity();
                courseEntity.setExamId(vo.getId());
                courseEntity.setCourseId(Long.valueOf(courseList.get(i)));
                courseEntity.setFullScore(Integer.valueOf(courseFullScoreList.get(i)));
                courseEntities.add(courseEntity);
            }
            eduExamCourseService.saveBatch(courseEntities);
        }
    }

    /**
     * 保存考试班级
     * @param vo
     */
    private void saveEduExamClazz(EduExamVO vo) {
        List<String> clazzList = vo.getClazzList();
        if (!clazzList.isEmpty()) {
            List<EduExamClazzEntity> clazzEntities = new ArrayList<>();
            for (String clazzId : clazzList) {
                EduExamClazzEntity clazzEntity = new EduExamClazzEntity();
                clazzEntity.setExamId(vo.getId());
                clazzEntity.setClazzId(Long.valueOf(clazzId));
                clazzEntities.add(clazzEntity);
            }
            eduExamClazzService.saveBatch(clazzEntities);
        }
    }

    @Override
    public void update(EduExamVO vo) {
        EduExamEntity entity = eduExamConvert.convert(vo);
        updateById(entity);

        // 删除原有关联数据，重新保存
        eduExamClazzService.remove(new LambdaQueryWrapper<EduExamClazzEntity>().eq(EduExamClazzEntity::getExamId, vo.getId()));
        this.saveEduExamClazz(vo);

        // 删除原有关联数据，重新保存
        eduExamCourseService.remove(new LambdaQueryWrapper<EduExamCourseEntity>().eq(EduExamCourseEntity::getExamId, vo.getId()));
        this.saveEduExamCourse(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
        // 删除考试班级表记录和考试科目表记录
        eduExamClazzService.remove(new LambdaQueryWrapper<EduExamClazzEntity>().in(EduExamClazzEntity::getExamId, idList));
        eduExamCourseService.remove(new LambdaQueryWrapper<EduExamCourseEntity>().in(EduExamCourseEntity::getExamId, idList));
    }

}
