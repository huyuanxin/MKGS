package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.mapper.neo4j.RelatedDisease3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("RelatedDiseaseInsertStrategy")
public class RelatedDiseaseInsertStrategy implements InsertStrategy {

    final private Disease3dMapper disease3dMapper;
    final private RelatedDisease3dMapper relatedDisease3dMapper;

    @Autowired
    public RelatedDiseaseInsertStrategy(Disease3dMapper disease3dMapper, RelatedDisease3dMapper relatedDisease3dMapper) {
        this.disease3dMapper = disease3dMapper;
        this.relatedDisease3dMapper = relatedDisease3dMapper;
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
        } else if (relatedDisease3dMapper.isExits(entityName) >= 1) {
            return "RelatedDisease";
        } else {
            relatedDisease3dMapper.insertRelatedDisease(entityName);
        }
        return "RelatedDisease";
    }

}
