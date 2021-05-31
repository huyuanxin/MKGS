package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Ingredients3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("IngredientsInsertEntityStrategy")
public class IngredientsInsertEntityStrategy implements InsertEntityStrategy {

    final private Ingredients3dMapper ingredients3dMapper;

    @Autowired
    public IngredientsInsertEntityStrategy(Ingredients3dMapper ingredients3dMapper) {
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
