package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.DiseaseSite3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DiseaseSiteInsertStrategy")
public class DiseaseSiteInsertStrategy implements InsertStrategy {

    final private Disease3dMapper disease3dMapper;
    final private DiseaseSite3dMapper diseaseSite3dMapper;
    final private Symptom3dMapper symptom3dMapper;

    @Autowired
    public DiseaseSiteInsertStrategy(Disease3dMapper disease3dMapper, DiseaseSite3dMapper diseaseSite3dMapper, Symptom3dMapper symptom3dMapper) {
        this.disease3dMapper = disease3dMapper;
        this.diseaseSite3dMapper = diseaseSite3dMapper;
        this.symptom3dMapper = symptom3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (diseaseSite3dMapper.isExits(entityName) >= 1) {
            return "DiseaseSite";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else {
            diseaseSite3dMapper.insertDiseaseSite(entityName);
        }
        return "DiseaseSite";
    }

}
