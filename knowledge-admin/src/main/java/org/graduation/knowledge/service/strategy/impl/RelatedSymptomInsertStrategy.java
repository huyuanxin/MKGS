package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.RelatedSymptom3dMapper;
import org.graduation.knowledge.mapper.neo4j.Symptom3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("RelatedSymptomInsertStrategy")
public class RelatedSymptomInsertStrategy implements InsertStrategy {

    final private Symptom3dMapper symptom3dMapper;
    final private RelatedSymptom3dMapper relatedSymptom3dMapper;

    @Autowired
    public RelatedSymptomInsertStrategy(Symptom3dMapper symptom3dMapper, RelatedSymptom3dMapper relatedSymptom3dMapper) {
        this.symptom3dMapper = symptom3dMapper;
        this.relatedSymptom3dMapper = relatedSymptom3dMapper;
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
        } else if (relatedSymptom3dMapper.isExits(entityName) >= 1) {
            return "RelatedSymptom";
        } else {
            relatedSymptom3dMapper.insertRelatedSymptom(entityName);
        }
        return "RelatedSymptom";
    }

}
