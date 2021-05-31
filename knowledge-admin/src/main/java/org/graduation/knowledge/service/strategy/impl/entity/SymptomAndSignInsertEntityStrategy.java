package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomAndSign3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("SymptomAndSignInsertEntityStrategy")
public class SymptomAndSignInsertEntityStrategy implements InsertEntityStrategy {

    final private Disease3dMapper disease3dMapper;
    final private Symptom3dMapper symptom3dMapper;
    final private SymptomAndSign3dMapper symptomAndSign3dMapper;

    @Autowired
    public SymptomAndSignInsertEntityStrategy(Disease3dMapper disease3dMapper, Symptom3dMapper symptom3dMapper, SymptomAndSign3dMapper symptomAndSign3dMapper) {
        this.disease3dMapper = disease3dMapper;
        this.symptom3dMapper = symptom3dMapper;
        this.symptomAndSign3dMapper = symptomAndSign3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (symptomAndSign3dMapper.isExits(entityName) >= 1) {
            return "SymptomAndSign";
        } else {
            symptomAndSign3dMapper.insertSymptomAndSign(entityName);
        }
        return "SymptomAndSign";
    }

}
