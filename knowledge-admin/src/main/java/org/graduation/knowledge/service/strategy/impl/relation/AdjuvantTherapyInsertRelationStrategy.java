package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("adjuvantTherapyInsertRelationStrategy")
public class AdjuvantTherapyInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "Disease";
    public static final String ADJUVANT_THERAPY = "AdjuvantTherapy";
    public static final String TREATMENT = "Treatment";
    public static final String SYMPTOM = "Symptom";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public AdjuvantTherapyInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
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
        if (DISEASE.equals(headType) && ADJUVANT_THERAPY.equals(tailType)) {
            diseaseRelation3dMapper.insertRelAdjuvantTherapyDTA(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && TREATMENT.equals(tailType)) {
            diseaseRelation3dMapper.insertRelAdjuvantTherapyDTT(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && ADJUVANT_THERAPY.equals(tailType)) {
            symptomRelation3dMapper.insertRelAdjuvantTherapySTA(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && TREATMENT.equals(tailType)) {
            symptomRelation3dMapper.insertRelAdjuvantTherapySTT(headName, tailName);
            return true;
        }
        return false;
    }

}
