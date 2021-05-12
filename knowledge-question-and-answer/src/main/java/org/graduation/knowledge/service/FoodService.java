package org.graduation.knowledge.service;

import org.graduation.knowledge.model.node.Disease;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface FoodService {

    /**
     * 已知忌口查疾病
     *
     * @param foodName 食物名
     * @return 已知忌口查疾病
     */
    List<Disease> getDiseaseByNotToEat(String foodName);

    /**
     * 已知推荐查疾病
     *
     * @param foodName 食物名
     * @return 已知推荐查疾病
     */
    List<Disease> getDiseaseByGoodToEat(String foodName);

    /**
     * 已知推荐查疾病
     *
     * @param foodName 食物名
     * @return 已知推荐查疾病
     */
    List<Disease> getDiseaseByRecommendToEat(String foodName);
}
