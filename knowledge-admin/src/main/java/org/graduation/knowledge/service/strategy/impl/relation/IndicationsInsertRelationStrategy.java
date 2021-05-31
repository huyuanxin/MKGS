package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DrugRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("indicationsInsertRelationStrategy")
public class IndicationsInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DRUG = "drug";
    public static final String DISEASE = "disease";
    public static final String SYMPTOM = "symptom";
    public static final String COMPLICATION = "complication";
    public static final String INDICATIONS = "indications";
    final private DrugRelation3dMapper drugRelation3dMapper;

    @Autowired
    public IndicationsInsertRelationStrategy(DrugRelation3dMapper drugRelation3dMapper) {
        this.drugRelation3dMapper = drugRelation3dMapper;
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
        if (DRUG.equals(headType) && INDICATIONS.equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTI(headName, tailName);
            return true;
        } else if (DRUG.equals(headType) && DISEASE.equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTD(headName, tailName);
            return true;
        } else if (DRUG.equals(headType) && SYMPTOM.equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTS(headName, tailName);
            return true;
        } else if (DRUG.equals(headType) && COMPLICATION.equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTE(headName, tailName);
            return true;
        }
        return false;
    }

}
