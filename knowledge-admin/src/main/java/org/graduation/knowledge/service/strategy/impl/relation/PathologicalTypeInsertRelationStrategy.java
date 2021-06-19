package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("pathologicalTypeInsertRelationStrategy")
public class PathologicalTypeInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "Disease";
    public static final String SYMPTOM = "Symptom";
    public static final String PATHOLOGICAL_TYPE = "PathologicalType";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public PathologicalTypeInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
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
        if (DISEASE.equals(headType) && PATHOLOGICAL_TYPE.equals(tailType)) {
            diseaseRelation3dMapper.insertRelPathologicalTypeDTO(headName, tailName);
            return true;
        } else if (SYMPTOM.equals(headType) && PATHOLOGICAL_TYPE.equals(tailType)) {
            symptomRelation3dMapper.insertRelPathologicalType(headName, tailName);
            return true;
        }
        return false;
    }

}
