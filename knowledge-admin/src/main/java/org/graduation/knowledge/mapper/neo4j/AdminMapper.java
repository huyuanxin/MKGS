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

    /**
     * 通过label类型获得该类型的全部数据
     *
     * @param entityType entities的类型
     * @return 该类型的全部entities
     */
    List<Entity> getAllEntitiesByType(@Param("entityType") String entityType);

    /**
     * 获得全部label
     *
     * @return 全部的label
     */
    List<String> getAllEntitiesType();

    /**
     * 获得全部relations
     *
     * @return 全部relations
     */
    List<String> getAllRelations();

    /**
     * 插入新的关系
     *
     * @param headName     头节点的名称
     * @param tailName     尾节点的名称
     * @param headType     头节点的类型
     * @param tailType     尾节点的类型
     * @param relationName 关系名
     */
    void insertNewRelation(@Param("headName") String headName, @Param("tailName") String tailName, @Param("headType") String headType, @Param("tailType") String tailType, @Param("relationName") String relationName);

    /**
     * 查询两个关系特定关系的个数
     *
     * @param headName     头节点的名称
     * @param tailName     尾节点的名称
     * @param headType     头节点的类型
     * @param tailType     尾节点的类型
     * @param relationName 关系名
     * @return 个数
     */
    Long countRelationsBetweenTwoEntities(@Param("headName") String headName, @Param("tailName") String tailName, @Param("headType") String headType, @Param("tailType") String tailType, @Param("relationName") String relationName);
}
