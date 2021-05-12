package org.graduation.knowledge;

import org.graduation.knowledge.mapper.answer.*;
import org.graduation.knowledge.util.SolrUtil;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@SuppressWarnings("JUnit5Platform")
@SelectClasses({
        // Mapper测试
        CheckNeo4jMapperTest.class,
        DiseaseNeo4jMapperTest.class,
        DrugNeo4jMapperTest.class,
        FoodNeo4jMapperTest.class,
        SymptomNeo4jMapperTest.class,
        DepartmentNeo4jMapperTest.class,
        ProducerNeo4jMapperTest.class,
        // Util测试
        SolrUtil.class
})
@RunWith(JUnitPlatform.class)
class KnowledgeStarterTests {

}
