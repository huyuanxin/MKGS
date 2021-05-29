package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Cause3dMapper;
import org.graduation.knowledge.mapper.neo4j.Disease3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("CauseInsertStrategy")
public class CauseInsertStrategy implements InsertStrategy {

    final private Disease3dMapper disease3dMapper;
    final private Cause3dMapper cause3dMapper;

    @Autowired
    public CauseInsertStrategy(Disease3dMapper disease3dMapper, Cause3dMapper cause3dMapper) {
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
