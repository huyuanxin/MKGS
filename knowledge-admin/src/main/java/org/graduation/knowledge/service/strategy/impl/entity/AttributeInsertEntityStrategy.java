package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Attribute3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("AttributeInsertEntityStrategy")
public class AttributeInsertEntityStrategy implements InsertEntityStrategy {

    final private Attribute3dMapper attribute3dMapper;

    @Autowired
    public AttributeInsertEntityStrategy(Attribute3dMapper attribute3dMapper) {
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
