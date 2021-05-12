package org.graduation.knowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author huyuanxin
 */
@EnableScheduling
@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableNeo4jRepositories("org.graduation.knowledge.mapper.neo4j")
public class KnowledgeStarter {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeStarter.class, args);
    }

}
