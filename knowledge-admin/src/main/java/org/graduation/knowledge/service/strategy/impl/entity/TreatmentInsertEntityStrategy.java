package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Treatment3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("TreatmentInsertEntityStrategy")
public class TreatmentInsertEntityStrategy implements InsertEntityStrategy {

    final private Treatment3dMapper treatment3dMapper;

    @Autowired
    public TreatmentInsertEntityStrategy(Treatment3dMapper treatment3dMapper) {
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
