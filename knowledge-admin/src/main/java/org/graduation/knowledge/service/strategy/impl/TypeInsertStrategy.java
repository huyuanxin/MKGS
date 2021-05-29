package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Type3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("TypeInsertStrategy")
public class TypeInsertStrategy implements InsertStrategy {

    final private Type3dMapper type3dMapper;

    @Autowired
    public TypeInsertStrategy(Type3dMapper type3dMapper) {
        this.type3dMapper = type3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (type3dMapper.isExits(entityName) < 1) {
            type3dMapper.insertType(entityName);
        }
        return "Type";
    }

}
