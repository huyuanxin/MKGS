package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("complicationInsertRelationStrategy")
public class ComplicationInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "disease";
    public static final String SYMPTOM = "symptom";
    public static final String COMPLICATION = "complication";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public ComplicationInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
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
        if (DISEASE.equals(headType) && COMPLICATION.equals(tailType)) {
            diseaseRelation3dMapper.insertRelComplicationDTC(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && DISEASE.equals(tailType)) {
            diseaseRelation3dMapper.insertRelComplicationDTD(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && SYMPTOM.equals(tailType)) {
            diseaseRelation3dMapper.insertRelComplicationDTS(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && DISEASE.equals(tailType)) {
            symptomRelation3dMapper.insertRelComplicationSTD(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && SYMPTOM.equals(tailType)) {
            symptomRelation3dMapper.insertRelComplicationSTS(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && COMPLICATION.equals(tailType)) {
            symptomRelation3dMapper.insertRelComplicationSTC(headName, tailName);
            return true;
        }
        return false;
    }

}
