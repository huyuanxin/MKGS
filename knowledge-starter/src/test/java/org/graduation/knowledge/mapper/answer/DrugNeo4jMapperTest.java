package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.DrugNeo4jMapper;
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
public class DrugNeo4jMapperTest {
    @Autowired
    DrugNeo4jMapper drugNeo4jMapper;

    @Test
    @DisplayName("已知药品查询能够治疗的疾病")
    public void getDiseaseByCommonDrug() {
        List<Disease> diseaseList = drugNeo4jMapper.getDiseaseByCommonDrug("感冒灵颗粒");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("已知药品查询能够治疗的疾病")
    public void getDiseaseByRecommendDrug() {
        List<Disease> diseaseList = drugNeo4jMapper.getDiseaseByRecommendDrug("感冒灵颗粒");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("查询药物是否存在")
    void countByName() {
        Long num = drugNeo4jMapper.countByName("安胎丸");
        Assertions.assertEquals(1, num);
    }
}