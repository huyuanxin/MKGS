package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("spreadWayInsertRelationStrategy")
public class SpreadWayInsertRelationStrategy implements InsertRelationStrategy {

    public static final String SYMPTOM = "Symptom";
    public static final String SPREAD_WAY = "SpreadWay";
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public SpreadWayInsertRelationStrategy(SymptomRelation3dMapper symptomRelation3dMapper) {
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
        if (SYMPTOM.equals(headType) && SPREAD_WAY.equals(tailType)) {
            symptomRelation3dMapper.insertRelSpreadWaySTSW(headName, tailName);
            return true;
        }
        return false;
    }

}
