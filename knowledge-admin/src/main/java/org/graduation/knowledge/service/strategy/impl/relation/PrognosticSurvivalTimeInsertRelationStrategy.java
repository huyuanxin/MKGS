package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("prognosticSurvivalTimeInsertRelationStrategy")
public class PrognosticSurvivalTimeInsertRelationStrategy implements InsertRelationStrategy {

    public final static String DISEASE = "disease";
    public final static String PROGNOSTIC_SURVIVAL_TIME = "prognosticSurvivalTime";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;

    @Autowired
    public PrognosticSurvivalTimeInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper) {
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
        if (DISEASE.equals(headType) && PROGNOSTIC_SURVIVAL_TIME.equals(tailType)) {
            diseaseRelation3dMapper.insertRelPrognosticSurvivalTimeDTP(headName, tailName);
            return true;
        }
        return false;
    }

}
