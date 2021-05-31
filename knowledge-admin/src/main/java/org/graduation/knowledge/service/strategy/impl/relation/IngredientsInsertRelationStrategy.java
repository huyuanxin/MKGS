package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DrugRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("ingredientsInsertRelationStrategy")
public class IngredientsInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DRUG = "drug";
    public static final String INGREDIENTS = "ingredients";
    final private DrugRelation3dMapper drugRelation3dMapper;

    @Autowired
    public IngredientsInsertRelationStrategy(DrugRelation3dMapper drugRelation3dMapper) {
        this.drugRelation3dMapper = drugRelation3dMapper;
    }

    /**
     * 插入关系
     *
     * @param headName 头节点的名称
     * @param tailName 尾节点的名称
     * @param headType 头节点的类型
     * @param tailType 尾节点的类型
     * @return 是否成功
     */
    @Override
    public Boolean insertRelation(String headName, String tailName, String headType, String tailType) {
        if (DRUG.equals(headType) && INGREDIENTS.equals(tailType)) {
            drugRelation3dMapper.insertRelIngredientsDTI(headName, tailName);
            return true;
        }
        return false;
    }

}
