package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Complication3dMapper;
import org.graduation.knowledge.mapper.neo4j.Contraindications3dMapper;
import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("ContraindicationsInsertStrategy")
public class ContraindicationsInsertStrategy implements InsertStrategy {

    final private Symptom3dMapper symptom3dMapper;
    final private Disease3dMapper disease3dMapper;
    final private Complication3dMapper complication3dMapper;
    final private Contraindications3dMapper contraindications3dMapper;

    @Autowired
    public ContraindicationsInsertStrategy(Symptom3dMapper symptom3dMapper, Disease3dMapper disease3dMapper, Complication3dMapper complication3dMapper, Contraindications3dMapper contraindications3dMapper) {
        this.symptom3dMapper = symptom3dMapper;
        this.disease3dMapper = disease3dMapper;
        this.complication3dMapper = complication3dMapper;
        this.contraindications3dMapper = contraindications3dMapper;
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
        } else if (contraindications3dMapper.isExits(entityName) >= 1) {
            return "Contraindications";
        } else {
            contraindications3dMapper.insertContraindications(entityName);
        }
        return "Contraindications";
    }
}
