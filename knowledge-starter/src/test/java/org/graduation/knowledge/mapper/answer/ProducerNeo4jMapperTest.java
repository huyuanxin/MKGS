package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.ProducerNeo4jMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huyuanxin
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProducerNeo4jMapperTest {

    @Autowired
    ProducerNeo4jMapper producerNeo4jMapper;

    @Test
    @DisplayName("查询药品是否存在")
    void countByName() {
        Long num = producerNeo4jMapper.countByName("本天药业依托红霉素片");
        Assertions.assertEquals(1, num);
    }
}