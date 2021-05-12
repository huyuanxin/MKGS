package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.DiseaseNeo4jMapper;
import org.graduation.knowledge.model.node.*;
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
public class DiseaseNeo4jMapperTest {
    @Autowired
    DiseaseNeo4jMapper diseaseNeo4jMapper;

    @Test
    @DisplayName("通过病名查询疾病实体")
    public void getDiseaseByName() {
        Disease disease = diseaseNeo4jMapper.getDiseaseByDiseaseName("感冒");
        System.out.println(disease);
        Assertions.assertNotNull(disease);
    }

    @Test
    @DisplayName("查询疾病有哪些症状")
    public void getSymptomByDiseaseName() {
        List<Symptom> symptomList = diseaseNeo4jMapper.getSymptomByDiseaseName("感冒");
        symptomList.forEach(System.out::println);
        Assertions.assertNotNull(symptomList);
        Assertions.assertNotEquals(0, symptomList.size());
    }

    @Test
    @DisplayName("查询疾病的并发症")
    public void getAccompanyByDiseaseName() {
        List<Disease> diseaseList = diseaseNeo4jMapper.getAccompanyByDiseaseName("感冒");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("反向查询疾病的并发症,即是diseaseAccompany的反向查询")
    public void getAccompanyReverseByDiseaseName() {
        List<Disease> diseaseList = diseaseNeo4jMapper.getAccompanyReverseByDiseaseName("感冒");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("查询疾病的忌口")
    public void getNotEatFoodByDiseaseName() {
        List<Food> foodList = diseaseNeo4jMapper.getNotEatFoodByDiseaseName("感冒");
        foodList.forEach(System.out::println);
        Assertions.assertNotNull(foodList);
        Assertions.assertNotEquals(0, foodList.size());
    }

    @Test
    @DisplayName("查询疾病建议吃的食物")
    public void getRecommendFoodByDiseaseName() {
        List<Food> foodList = diseaseNeo4jMapper.getRecommendFoodByDiseaseName("感冒");
        foodList.forEach(System.out::println);
        Assertions.assertNotNull(foodList);
        Assertions.assertNotEquals(0, foodList.size());
    }

    @Test
    @DisplayName("查询疾病建议吃的食谱")
    public void getRecommendRecipeByDiseaseName() {
        List<Food> foodList = diseaseNeo4jMapper.getRecommendRecipeByDiseaseName("感冒");
        foodList.forEach(System.out::println);
        Assertions.assertNotNull(foodList);
        Assertions.assertNotEquals(0, foodList.size());
    }

    @Test
    @DisplayName("查询疾病常用药品")
    public void getCommonDrugByDiseaseName() {
        List<Drug> drugList = diseaseNeo4jMapper.getCommonDrugByDiseaseName("感冒");
        drugList.forEach(System.out::println);
        Assertions.assertNotNull(drugList);
        Assertions.assertNotEquals(0, drugList.size());
    }

    @Test
    @DisplayName("查询疾病推荐药品")
    public void getRecommendDrugByDiseaseName() {
        List<Drug> drugList = diseaseNeo4jMapper.getRecommendDrugByDiseaseName("感冒");
        drugList.forEach(System.out::println);
        Assertions.assertNotNull(drugList);
        Assertions.assertNotEquals(0, drugList.size());
    }

    @Test
    @DisplayName("查询疾病应该进行的检查")
    public void getCheckByDiseaseName() {
        List<Check> checkList = diseaseNeo4jMapper.getCheckByDiseaseName("感冒");
        checkList.forEach(System.out::println);
        Assertions.assertNotNull(checkList);
        Assertions.assertNotEquals(0, checkList.size());
    }

    @Test
    @DisplayName("查询疾病是否存在")
    void countByName() {
        Long num = diseaseNeo4jMapper.countByName("心脏病");
        Assertions.assertEquals(1, num);
    }
}
