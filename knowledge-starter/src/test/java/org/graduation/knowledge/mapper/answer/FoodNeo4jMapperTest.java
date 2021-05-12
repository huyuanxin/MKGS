package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.FoodNeo4jMapper;
import org.graduation.knowledge.model.node.Disease;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author huyuanxin
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FoodNeo4jMapperTest {
    @Autowired
    FoodNeo4jMapper foodNeo4jMapper;

    @Test
    @DisplayName("已知忌口查疾病")
    public void getDiseaseByNotToEat() {
        List<Disease> diseaseList = foodNeo4jMapper.getDiseaseByNotToEat("油条");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("已知推荐查疾病")
    public void getDiseaseByGoodToEat() {
        List<Disease> diseaseList = foodNeo4jMapper.getDiseaseByGoodToEat("芝麻");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("已知推荐查疾病")
    public void getDiseaseByRecommendToEat() {
        List<Disease> diseaseList = foodNeo4jMapper.getDiseaseByRecommendToEat("赤小豆粥");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("查询食物是否存在")
    void countByName() {
        Long num = foodNeo4jMapper.countByName("卤五花肉");
        Assertions.assertEquals(1, num);
    }
}