package org.graduation.knowledge.mapper.neo4j.relation;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.graduation.knowledge.model.relation.RelsCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("QA")
public interface RelsCategoryNeo4jMapper {

    List<RelsCategory> insertRelation(String startNode, String endNode, String relName);
}
