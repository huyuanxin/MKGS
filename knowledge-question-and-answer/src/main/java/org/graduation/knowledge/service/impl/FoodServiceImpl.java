package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.mapper.neo4j.node.FoodNeo4jMapper;
import org.graduation.knowledge.model.node.Disease;
import org.graduation.knowledge.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyuanxin
 */
@Service
public class FoodServiceImpl implements FoodService {
    final FoodNeo4jMapper foodNeo4jMapper;

    @Autowired
    public FoodServiceImpl(FoodNeo4jMapper foodNeo4jMapper) {
        this.foodNeo4jMapper = foodNeo4jMapper;
    }

    @Override
    public List<Disease> getDiseaseByNotToEat(String name) {
        return foodNeo4jMapper.getDiseaseByNotToEat(name);
    }

    @Override
    public List<Disease> getDiseaseByGoodToEat(String name) {
        return foodNeo4jMapper.getDiseaseByGoodToEat(name);
    }

    @Override
    public List<Disease> getDiseaseByRecommendToEat(String name) {
        return foodNeo4jMapper.getDiseaseByRecommendToEat(name);
    }

}
