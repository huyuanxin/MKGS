package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("SymptomInsertEntityStrategy")
public class SymptomInsertEntityStrategy implements InsertEntityStrategy {

    final private Symptom3dMapper symptom3dMapper;
    final private Disease3dMapper disease3dMapper;

    @Autowired
    public SymptomInsertEntityStrategy(Symptom3dMapper symptom3dMapper, Disease3dMapper disease3dMapper) {
        this.symptom3dMapper = symptom3dMapper;
        this.disease3dMapper = disease3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else {
            symptom3dMapper.insertSymptom(entityName);
        }
        return "Symptom";
    }

}
