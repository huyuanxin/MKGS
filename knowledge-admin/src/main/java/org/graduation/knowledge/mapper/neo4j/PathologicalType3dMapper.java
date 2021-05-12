package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface PathologicalType3dMapper {

    /**
     * 初始化病理分型
     */
    void initPathologicalType();

    /**
     * 查询指定名字的病理分型的个数
     *
     * @param pathologicalTypeName 病理分型的名字
     * @return 个数
     */
    long isExits(@Param("pathologicalTypeName") String pathologicalTypeName);

    /**
     * 插入病理分型
     *
     * @param pathologicalTypeName 病理分型的名字
     */
    void insertPathologicalType(@Param("pathologicalTypeName") String pathologicalTypeName);

}
