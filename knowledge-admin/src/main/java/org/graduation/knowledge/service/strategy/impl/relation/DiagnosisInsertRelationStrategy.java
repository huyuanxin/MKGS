package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("diagnosisInsertRelationStrategy")
public class DiagnosisInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "disease";
    public static final String DIAGNOSIS = "diagnosis";
    public static final String TREATMENT = "treatment";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;

    @Autowired
    public DiagnosisInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper) {
        this.diseaseRelation3dMapper = diseaseRelation3dMapper;
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
        if (DISEASE.equals(headType) && DIAGNOSIS.equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiagnosisDTT(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && TREATMENT.equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiagnosisDTDI(headName, tailName);
            return true;
        }
        return false;
    }

}
