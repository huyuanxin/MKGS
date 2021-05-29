package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.*;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("TreatmentProgramsInsertStrategy")
public class TreatmentProgramsInsertStrategy implements InsertStrategy {

    final private AdjuvantTherapy3dMapper adjuvantTherapy3dMapper;
    final private Drug3dMapper drug3dMapper;
    final private DrugTherapy3dMapper drugTherapy3dMapper;
    final private AuxiliaryExamination3dMapper auxiliaryExamination3dMapper;
    final private Treatment3dMapper treatment3dMapper;
    final private Operation3dMapper operation3dMapper;
    final private TreatmentPrograms3dMapper treatmentPrograms3dMapper;
    final private Check3dMapper check3dMapper;

    @Autowired
    public TreatmentProgramsInsertStrategy(AdjuvantTherapy3dMapper adjuvantTherapy3dMapper, Drug3dMapper drug3dMapper, DrugTherapy3dMapper drugTherapy3dMapper, AuxiliaryExamination3dMapper auxiliaryExamination3dMapper, Treatment3dMapper treatment3dMapper, Operation3dMapper operation3dMapper, TreatmentPrograms3dMapper treatmentPrograms3dMapper, Check3dMapper check3dMapper) {
        this.adjuvantTherapy3dMapper = adjuvantTherapy3dMapper;
        this.drug3dMapper = drug3dMapper;
        this.drugTherapy3dMapper = drugTherapy3dMapper;
        this.auxiliaryExamination3dMapper = auxiliaryExamination3dMapper;
        this.treatment3dMapper = treatment3dMapper;
        this.operation3dMapper = operation3dMapper;
        this.treatmentPrograms3dMapper = treatmentPrograms3dMapper;
        this.check3dMapper = check3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (adjuvantTherapy3dMapper.isExits(entityName) >= 1) {
            return "AdjuvantTherapy";
        } else if (drugTherapy3dMapper.isExits(entityName) >= 1) {
            return "DrugTherapy";
        } else if (drug3dMapper.isExits(entityName) >= 1) {
            return "Drug";
        } else if (treatment3dMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "AuxiliaryExamination";
        } else if (operation3dMapper.isExits(entityName) >= 1) {
            return "Operation";
        } else if (treatmentPrograms3dMapper.isExits(entityName) >= 1) {
            return "TreatmentPrograms";
        } else {
            treatmentPrograms3dMapper.insertTreatmentPrograms(entityName);
        }
        return "TreatmentPrograms";
    }

}
