package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.Pathophysiology3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PathophysiologyInsertStrategy")
public class PathophysiologyInsertStrategy implements InsertStrategy {

    final private Symptom3dMapper symptom3dMapper;
    final private Disease3dMapper disease3dMapper;
    final private Pathophysiology3dMapper pathophysiology3dMapper;

    @Autowired
    public PathophysiologyInsertStrategy(Symptom3dMapper symptom3dMapper, Disease3dMapper disease3dMapper, Pathophysiology3dMapper pathophysiology3dMapper) {
        this.symptom3dMapper = symptom3dMapper;
        this.disease3dMapper = disease3dMapper;
        this.pathophysiology3dMapper = pathophysiology3dMapper;
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
        } else if (pathophysiology3dMapper.isExits(entityName) >= 1) {
            return "Pathophysiology";
        } else {
            pathophysiology3dMapper.insertPathophysiology(entityName);
        }
        return "Pathophysiology";
    }

}
