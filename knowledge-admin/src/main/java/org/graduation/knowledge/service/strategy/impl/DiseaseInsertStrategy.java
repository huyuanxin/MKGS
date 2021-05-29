package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DiseaseInsertStrategy")
public class DiseaseInsertStrategy implements InsertStrategy {

    final private Symptom3dMapper symptom3dMapper;
    final private Disease3dMapper disease3dMapper;

    @Autowired
    public DiseaseInsertStrategy(Symptom3dMapper symptom3dMapper, Disease3dMapper disease3dMapper) {
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
            disease3dMapper.insertDisease(entityName);
        }
        return "Disease";
    }

}
