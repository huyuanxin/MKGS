package org.graduation.knowledge.mapper.neo4j.node;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.graduation.knowledge.model.node.Disease;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("QA")
public interface SymptomNeo4jMapper {
    /**
     * 查询症状会导致哪些疾病
     *
     * @param symptomName 症状名
     * @return 查询症状会导致哪些疾病
     */
    List<Disease> getDiseaseBySymptom(@Param("symptomName") String symptomName);

    /**
     * 获得指定名称检查的数量，用来判断是否存在
     *
     * @param name 检查的名称
     * @return 数量
     */
    Long countByName(@Param("name") String name);
}
