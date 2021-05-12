package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.SymptomNeo4jMapper;
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
public class SymptomNeo4jMapperTest {
    @Autowired
    SymptomNeo4jMapper symptomNeo4jMapper;

    @Test
    @DisplayName("查询症状会导致哪些疾病")
    public void getDiseaseBySymptom() {
        List<Disease> diseaseList = symptomNeo4jMapper.getDiseaseBySymptom("头晕");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("查询症状是否存在")
    void countByName() {
        Long num = symptomNeo4jMapper.countByName("上焦火");
        Assertions.assertEquals(1, num);
    }
}