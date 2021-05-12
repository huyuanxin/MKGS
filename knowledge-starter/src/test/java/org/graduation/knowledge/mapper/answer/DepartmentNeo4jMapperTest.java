package org.graduation.knowledge.mapper.answer;

import org.graduation.knowledge.mapper.neo4j.node.DepartmentNeo4jMapper;
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
public class DepartmentNeo4jMapperTest {

    @Autowired
    DepartmentNeo4jMapper departmentNeo4jMapper;

    @Test
    @DisplayName("查询科室是否存在")
    void countByName() {
        Long num = departmentNeo4jMapper.countByName("眼科");
        Assertions.assertEquals(1, num);
    }
}