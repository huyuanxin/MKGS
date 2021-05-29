package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.MultipleGroups3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("MultipleGroupsInsertStrategy")
public class MultipleGroupsInsertStrategy implements InsertStrategy {

    final private MultipleGroups3dMapper multipleGroups3dMapper;

    @Autowired
    public MultipleGroupsInsertStrategy(MultipleGroups3dMapper multipleGroups3dMapper) {
        this.multipleGroups3dMapper = multipleGroups3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (multipleGroups3dMapper.isExits(entityName) < 1) {
            multipleGroups3dMapper.insertMultipleGroups(entityName);
        }
        return "MultipleGroups";
    }

}
