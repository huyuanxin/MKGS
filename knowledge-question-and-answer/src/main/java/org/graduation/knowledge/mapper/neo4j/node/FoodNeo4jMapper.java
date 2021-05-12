package org.graduation.knowledge.mapper.neo4j.node;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.graduation.knowledge.model.node.Disease;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("QA")
public interface FoodNeo4jMapper {
    /**
     * 已知忌口查疾病
     *
     * @param foodName 食物名称
     * @return 已知忌口查疾病
     */
    List<Disease> getDiseaseByNotToEat(@Param("foodName") String foodName);

    /**
     * 已知推荐查疾病
     *
     * @param foodName 食物名称
     * @return 已知推荐查疾病
     */
    List<Disease> getDiseaseByGoodToEat(@Param("foodName") String foodName);

    /**
     * 已知推荐查疾病
     *
     * @param foodName 食物名称
     * @return 已知推荐查疾病
     */
    List<Disease> getDiseaseByRecommendToEat(@Param("foodName") String foodName);

    /**
     * 获得指定名称食物的数量，用来判断是否存在
     *
     * @param name 检查的名称
     * @return 数量
     */
    Long countByName(@Param("name") String name);
}
