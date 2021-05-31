package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Operation3dMapper;
import org.graduation.knowledge.mapper.neo4j.Treatment3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("OperationInsertEntityStrategy")
public class OperationInsertEntityStrategy implements InsertEntityStrategy {

    final private Treatment3dMapper treatment3dMapper;
    final private Operation3dMapper operation3dMapper;

    @Autowired
    public OperationInsertEntityStrategy(Treatment3dMapper treatment3dMapper, Operation3dMapper operation3dMapper) {
        this.treatment3dMapper = treatment3dMapper;
        this.operation3dMapper = operation3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (treatment3dMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else if (operation3dMapper.isExits(entityName) >= 1) {
            return "Operation";
        } else {
            operation3dMapper.insertOperation(entityName);
        }
        return "Operation";
    }

}
