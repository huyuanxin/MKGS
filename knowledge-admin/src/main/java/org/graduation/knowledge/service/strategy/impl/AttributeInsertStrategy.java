package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Attribute3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("AttributeInsertStrategy")
public class AttributeInsertStrategy implements InsertStrategy {

    final private Attribute3dMapper attribute3dMapper;

    @Autowired
    public AttributeInsertStrategy(Attribute3dMapper attribute3dMapper) {
        this.attribute3dMapper = attribute3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (attribute3dMapper.isExits(entityName) < 1) {
            attribute3dMapper.insertAttribute(entityName);
        }
        return "Attribute";
    }

}
