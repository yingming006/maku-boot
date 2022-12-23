package net.maku.edu.convert.impl;

import net.maku.edu.convert.EduExamConvert;
import net.maku.edu.entity.EduExamClazzEntity;
import net.maku.edu.entity.EduExamEntity;
import net.maku.edu.query.EduExamQuery;
import net.maku.edu.service.EduExamClazzService;
import net.maku.edu.vo.EduExamVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EduExamConvertImpl implements EduExamConvert {

    private final EduExamClazzService eduExamClazzService;

    public EduExamConvertImpl(EduExamClazzService eduExamClazzService) {
        this.eduExamClazzService = eduExamClazzService;
    }

    @Override
    public EduExamEntity convert(EduExamVO vo) {
        if (vo == null) {
            return null;
        }

        EduExamEntity eduExamEntity = new EduExamEntity();

        eduExamEntity.setId(vo.getId());
        eduExamEntity.setCreator(vo.getCreator());
        eduExamEntity.setCreateTime(vo.getCreateTime());
        eduExamEntity.setUpdater(vo.getUpdater());
        eduExamEntity.setUpdateTime(vo.getUpdateTime());
        eduExamEntity.setVersion(vo.getVersion());
        eduExamEntity.setDeleted(vo.getDeleted());
        eduExamEntity.setName(vo.getName());
        eduExamEntity.setType(vo.getType());
        eduExamEntity.setStartDate(vo.getStartDate());
        eduExamEntity.setEndDate(vo.getEndDate());
        eduExamEntity.setRemark(vo.getRemark());
        eduExamEntity.setIsEnabled(vo.getIsEnabled());
        eduExamEntity.setCourseList(vo.getCourseList());

        return eduExamEntity;
    }

    @Override
    public EduExamVO convert(EduExamEntity entity) {
        if (entity == null) {
            return null;
        }

        EduExamVO eduExamVO = new EduExamVO();

        eduExamVO.setId(entity.getId());
        eduExamVO.setName(entity.getName());
        eduExamVO.setType(entity.getType());
        eduExamVO.setStartDate(entity.getStartDate());
        eduExamVO.setEndDate(entity.getEndDate());
        eduExamVO.setRemark(entity.getRemark());
        eduExamVO.setIsEnabled(entity.getIsEnabled());
        eduExamVO.setDeleted(entity.getDeleted());
        eduExamVO.setVersion(entity.getVersion());
        eduExamVO.setCreator(entity.getCreator());
        eduExamVO.setCreateTime(entity.getCreateTime());
        eduExamVO.setUpdater(entity.getUpdater());
        eduExamVO.setUpdateTime(entity.getUpdateTime());
        eduExamVO.setCourseList(entity.getCourseList());

        EduExamQuery query = new EduExamQuery();
        query.setId(entity.getId());
        List<EduExamClazzEntity> list = eduExamClazzService.list(query);

        List<String> clazzList = new ArrayList<>();
        for (EduExamClazzEntity eduExamClazzEntity : list) {
            clazzList.add(String.valueOf(eduExamClazzEntity.getClazzId()));
        }

        eduExamVO.setClazzList(clazzList);
        return eduExamVO;
    }

    @Override
    public List<EduExamVO> convertList(List<EduExamEntity> list) {
        if (list == null) {
            return null;
        }

        List<EduExamVO> list1 = new ArrayList<>(list.size());
        for (EduExamEntity eduExamEntity : list) {
            list1.add(convert(eduExamEntity));
        }

        return list1;
    }
}
