package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("drugTherapy")
public class DrugTherapyInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "Disease";
    public static final String SYMPTOM = "Symptom";
    public static final String DRUG = "Drug";
    public static final String DRUG_THERAPY = "DrugTherapy";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public DrugTherapyInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
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
        if (DISEASE.equals(headType) && DRUG_THERAPY.equals(tailType)) {
            diseaseRelation3dMapper.insertRelDrugTherapyDTDT(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && DRUG.equals(tailType)) {
            diseaseRelation3dMapper.insertRelDrugTherapyDTD(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && DRUG_THERAPY.equals(tailType)) {
            symptomRelation3dMapper.insertRelDrugTherapySTDT(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && DRUG.equals(tailType)) {
            symptomRelation3dMapper.insertRelDrugTherapySTD(headName, tailName);
            return true;
        }
        return false;
    }

}
