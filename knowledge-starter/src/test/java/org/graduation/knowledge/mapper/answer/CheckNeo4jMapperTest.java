package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.CheckNeo4jMapper;
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
public class CheckNeo4jMapperTest {
    @Autowired
    CheckNeo4jMapper checkNeo4jMapper;

    @Test
    @DisplayName("已知检查查询疾病")
    public void getDiseaseByCheckName() {
        List<Disease> diseaseList = checkNeo4jMapper.getDiseaseByCheckName("血压");
        diseaseList.forEach(System.out::println);
        Assertions.assertNotNull(diseaseList);
        Assertions.assertNotEquals(0, diseaseList.size());
    }

    @Test
    @DisplayName("查询检查是否存在")
    void countByName() {
        Long num = checkNeo4jMapper.countByName("韦伯试验");
        Assertions.assertEquals(1, num);

    }
}
