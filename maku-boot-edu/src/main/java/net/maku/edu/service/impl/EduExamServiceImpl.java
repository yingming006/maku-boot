package net.maku.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.edu.convert.EduExamConvert;
import net.maku.edu.dao.EduExamDao;
import net.maku.edu.dao.EduExamStudentDao;
import net.maku.edu.entity.*;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.service.*;
import net.maku.edu.vo.EduExamVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 考试信息表
 *
 * @author yingming006 yingming006@foxmail.com
 * @since 1.0.0 2022-12-15
 */
@Service
@AllArgsConstructor
public class EduExamServiceImpl extends BaseServiceImpl<EduExamDao, EduExamEntity> implements EduExamService {

    @Autowired
    private EduExamConvert eduExamConvert;

    @Autowired
    private EduExamClazzService eduExamClazzService;

    @Autowired
    private EduExamCourseService eduExamCourseService;

    @Autowired
    private EduStudentService eduStudentService;

    @Autowired
    private EduExamStudentDao eduExamStudentDao;

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

        // 保存考试班级、考试科目、考试学生
        saveEduExamClazz(vo);
        saveEduExamCourse(vo);
        saveEduExamStudent(vo);
    }

    /**
     * 保存考试学生信息
     * @param vo
     */
    private void saveEduExamStudent(EduExamVO vo) {
        List<String> clazzList = vo.getClazzList();

        List<EduStudentEntity> students = eduStudentService.list(new LambdaQueryWrapper<EduStudentEntity>().in(EduStudentEntity::getClazzId, clazzList));

        List<EduExamStudentEntity> entityList = students.stream()
                .map(stu-> EduExamStudentEntity.builder().examId(vo.getId()).studentId(stu.getId()).clazzId(stu.getClazzId()).build())
                .toList();

        entityList.forEach(eduExamStudentEntity -> eduExamStudentDao.insert(eduExamStudentEntity));
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

        // 删除原有关联数据，重新保存
        eduExamStudentDao.delete(new LambdaQueryWrapper<EduExamStudentEntity>().eq(EduExamStudentEntity::getExamId, vo.getId()));
        this.saveEduExamStudent(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
        // 删除考试班级表记录和考试科目表记录
        eduExamClazzService.remove(new LambdaQueryWrapper<EduExamClazzEntity>().in(EduExamClazzEntity::getExamId, idList));
        eduExamCourseService.remove(new LambdaQueryWrapper<EduExamCourseEntity>().in(EduExamCourseEntity::getExamId, idList));
        eduExamStudentDao.delete(new LambdaQueryWrapper<EduExamStudentEntity>().in(EduExamStudentEntity::getExamId, idList));
    }

}
