package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Complication3dMapper;
import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("ComplicationInsertStrategy")
public class ComplicationInsertStrategy implements InsertStrategy {

    final private Symptom3dMapper symptom3dMapper;
    final private Disease3dMapper disease3dMapper;
    final private Complication3dMapper complication3dMapper;

    @Autowired
    public ComplicationInsertStrategy(Symptom3dMapper symptom3dMapper, Disease3dMapper disease3dMapper, Complication3dMapper complication3dMapper) {
        this.symptom3dMapper = symptom3dMapper;
        this.disease3dMapper = disease3dMapper;
        this.complication3dMapper = complication3dMapper;
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
        } else {
            complication3dMapper.insertComplication(entityName);
        }
        return "Complication";
    }

}
