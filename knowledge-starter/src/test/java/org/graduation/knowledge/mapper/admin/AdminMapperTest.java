package org.graduation.knowledge.mapper.admin;

import org.graduation.knowledge.mapper.neo4j.AdminMapper;
import org.graduation.knowledge.model.Entity;
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
public class AdminMapperTest {
    @Autowired
    AdminMapper adminMapper;

    @Test
    void getAllRelationByName(){
        List<Entity> relation = adminMapper.getAllRelationByName("Bartter综合征");
        relation.forEach(System.out::println);
    }
}
