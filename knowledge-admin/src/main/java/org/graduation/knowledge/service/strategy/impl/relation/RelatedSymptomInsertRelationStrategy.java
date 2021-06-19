package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.TreatmentRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("relatedSymptomInsertRelationStrategy")
public class RelatedSymptomInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "Disease";
    public static final String TREATMENT = "Treatment";
    public static final String SYMPTOM = "Symptom";
    public static final String RELATED_SYMPTOM = "RelatedSymptom";

    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private TreatmentRelation3dMapper treatmentRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public RelatedSymptomInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, TreatmentRelation3dMapper treatmentRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
        this.diseaseRelation3dMapper = diseaseRelation3dMapper;
        this.treatmentRelation3dMapper = treatmentRelation3dMapper;
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
        if (DISEASE.equals(headType) && RELATED_SYMPTOM.equals(tailType)) {
            diseaseRelation3dMapper.insertRelRelatedSymptomDTR(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && SYMPTOM.equals(tailType)) {
            diseaseRelation3dMapper.insertRelRelatedSymptomDTS(headName, tailName);
            return true;
        } else if (TREATMENT.equals(headType) && RELATED_SYMPTOM.equals(tailType)) {
            treatmentRelation3dMapper.insertRelRelatedSymptomTTR(headName, tailName);
            return true;
        } else if (TREATMENT.equals(headType) && SYMPTOM.equals(tailType)) {
            treatmentRelation3dMapper.insertRelRelatedDiseaseTTS(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && RELATED_SYMPTOM.equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedSymptomSTR(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && SYMPTOM.equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedSymptomSTS(headName, tailName);
            return true;
        }
        return false;
    }

}
