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
public interface DrugNeo4jMapper {
    /**
     * 已知药品查询能够治疗的疾病
     *
     * @param drugName 药品名
     * @return 已知药品查询能够治疗的疾病
     */
    List<Disease> getDiseaseByCommonDrug(@Param("drugName") String drugName);

    /**
     * 已知药品查询能够治疗的疾病
     *
     * @param drugName 药品名
     * @return 已知药品查询能够治疗的疾病
     */
    List<Disease> getDiseaseByRecommendDrug(@Param("drugName") String drugName);

    /**
     * 获得指定名称药品的数量，用来判断是否存在
     *
     * @param name 检查的名称
     * @return 数量
     */
    Long countByName(@Param("name") String name);
}
