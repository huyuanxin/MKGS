package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Complication3dMapper;
import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Indications3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("IndicationsInsertEntityStrategy")
public class IndicationsInsertEntityStrategy implements InsertEntityStrategy {

    final private Disease3dMapper disease3dMapper;
    final private Symptom3dMapper symptom3dMapper;
    final private Complication3dMapper complication3dMapper;
    final private Indications3dMapper indications3dMapper;

    @Autowired
    public IndicationsInsertEntityStrategy(Disease3dMapper disease3dMapper, Symptom3dMapper symptom3dMapper, Complication3dMapper complication3dMapper, Indications3dMapper indications3dMapper) {
        this.disease3dMapper = disease3dMapper;
        this.symptom3dMapper = symptom3dMapper;
        this.complication3dMapper = complication3dMapper;
        this.indications3dMapper = indications3dMapper;
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
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "Complication";
        } else if (indications3dMapper.isExits(entityName) >= 1) {
            return "Indications";
        } else {
            indications3dMapper.insertIndications(entityName);
        }
        return "Indications";
    }
}
