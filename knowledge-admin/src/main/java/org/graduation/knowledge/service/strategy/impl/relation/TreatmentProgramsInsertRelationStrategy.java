package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("treatmentProgramsInsertRelationStrategy")
public class TreatmentProgramsInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "Disease";
    public static final String SYMPTOM = "Symptom";
    public static final String TREATMENT_PROGRAMS = "TreatmentPrograms";
    public static final String AUXILIARY_EXAMINATION = "AuxiliaryExamination";
    public static final String CHECK = "Check";
    public static final String TREATMENT = "Treatment";
    public static final String DRUG = "Drug";
    public static final String OPERATION = "Operation";
    public static final String DRUG_THERAPY = "DrugTherapy";
    public static final String ADJUVANT_THERAPY = "AdjuvantTherapy";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public TreatmentProgramsInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
        this.diseaseRelation3dMapper = diseaseRelation3dMapper;
        this.symptomRelation3dMapper = symptomRelation3dMapper;
    }

    /**
     * 插入关系
     *
     * @param headName 头节点的名称
     * @param tailName 尾节点的名称
     * @param headType 头节点的类型
     * @param tailType 尾节点的类型
     * @return 是否成功
     */
    @Override
    public Boolean insertRelation(String headName, String tailName, String headType, String tailType) {
        if (DISEASE.equals(headType) && TREATMENT_PROGRAMS.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTTP(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && ADJUVANT_THERAPY.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTA(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && DRUG_THERAPY.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTU(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && OPERATION.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTO(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && DRUG.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTD(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && TREATMENT.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTT(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && CHECK.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTC(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && AUXILIARY_EXAMINATION.equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTE(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && ADJUVANT_THERAPY.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTA(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && DRUG_THERAPY.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTU(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && OPERATION.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTO(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && DRUG.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTD(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && TREATMENT.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTT(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && CHECK.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTC(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && AUXILIARY_EXAMINATION.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTE(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && TREATMENT_PROGRAMS.equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTTP(headName, tailName);
            return true;
        }
        return false;
    }

}
