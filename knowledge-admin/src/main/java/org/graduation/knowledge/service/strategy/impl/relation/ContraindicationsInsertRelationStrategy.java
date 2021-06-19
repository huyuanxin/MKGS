package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DrugRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("contraindicationsInsertRelationStrategy")
public class ContraindicationsInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DRUG = "Drug";
    public static final String COMPLICATION = "Complication";
    public static final String SYMPTOM = "Symptom";
    public static final String DISEASE = "Disease";
    public static final String CONTRAINDICATIONS = "Contraindications";
    final private DrugRelation3dMapper drugRelation3dMapper;

    @Autowired
    public ContraindicationsInsertRelationStrategy(DrugRelation3dMapper drugRelation3dMapper) {
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
        if (DRUG.equals(headType) && CONTRAINDICATIONS.equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTC(headName, tailName);
            return true;
        } else if (DRUG.equals(headType) && DISEASE.equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTD(headName, tailName);
            return true;
        } else if (DRUG.equals(headType) && SYMPTOM.equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTS(headName, tailName);
            return true;
        } else if (DRUG.equals(headType) && COMPLICATION.equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTE(headName, tailName);
            return true;
        }
        return false;
    }

}
