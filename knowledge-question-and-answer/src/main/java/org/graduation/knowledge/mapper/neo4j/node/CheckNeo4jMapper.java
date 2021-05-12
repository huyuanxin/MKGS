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
public interface CheckNeo4jMapper {
    /**
     * 已知检查查询疾病
     *
     * @param checkName 检查项目
     * @return 已知检查查询疾病
     */
    List<Disease> getDiseaseByCheckName(@Param("checkName") String checkName);

    /**
     * 获得指定名称检查的数量，用来判断是否存在
     *
     * @param name 检查的名称
     * @return 数量
     */
    Long countByName(@Param("name") String name);
}
