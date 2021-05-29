package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Treatment3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("TreatmentInsertStrategy")
public class TreatmentInsertStrategy implements InsertStrategy {

    final private Treatment3dMapper treatment3dMapper;

    @Autowired
    public TreatmentInsertStrategy(Treatment3dMapper treatment3dMapper) {
        this.treatment3dMapper = treatment3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (treatment3dMapper.isExits(entityName) < 1) {
            treatment3dMapper.insertTreatment(entityName);
        }
        return "Treatment";
    }

}
