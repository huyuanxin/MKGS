package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.graduation.knowledge.model.Entity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface AdminMapper {

    /**
     * 通过实体名获得实体的关系
     *
     * @param entityName 实体名
     * @return 实体的关系
     */
    List<Entity> getAllRelationByName(@Param("entityName") String entityName);

}
