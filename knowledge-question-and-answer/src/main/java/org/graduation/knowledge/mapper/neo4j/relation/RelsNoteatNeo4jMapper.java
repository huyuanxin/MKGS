package org.graduation.knowledge.mapper.neo4j.relation;


import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.graduation.knowledge.model.relation.RelsNoteat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("QA")
public interface RelsNoteatNeo4jMapper {
    List<RelsNoteat> insertRelation(String startNode, String endNode, String relName);
}
