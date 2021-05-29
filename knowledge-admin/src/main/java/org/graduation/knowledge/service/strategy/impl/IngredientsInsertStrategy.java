package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Ingredients3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("IngredientsInsertStrategy")
public class IngredientsInsertStrategy implements InsertStrategy {

    final private Ingredients3dMapper ingredients3dMapper;

    @Autowired
    public IngredientsInsertStrategy(Ingredients3dMapper ingredients3dMapper) {
        this.ingredients3dMapper = ingredients3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (ingredients3dMapper.isExits(entityName) < 1) {
            ingredients3dMapper.insertIngredients(entityName);
        }
        return "Ingredients";
    }

}
