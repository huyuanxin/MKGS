package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Cause3dMapper;
import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("CauseInsertEntityStrategy")
public class CauseInsertEntityStrategy implements InsertEntityStrategy {

    final private Disease3dMapper disease3dMapper;
    final private Cause3dMapper cause3dMapper;

    @Autowired
    public CauseInsertEntityStrategy(Disease3dMapper disease3dMapper, Cause3dMapper cause3dMapper) {
        this.disease3dMapper = disease3dMapper;
        this.cause3dMapper = cause3dMapper;
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
        } else if (cause3dMapper.isExits(entityName) >= 1) {
            return "Cause";
        } else {
            cause3dMapper.insertCause(entityName);
        }
        return "Cause";
    }

}
