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
public interface Type3dMapper {
    /**
     * 初始化Type,设置Type的name为唯一值
     */
    void initType();

    /**
     * 插入分类
     *
     * @param typeName 分类名称
     */
    void insertType(@Param("typeName") String typeName);

    /**
     * 返回特点名称分类的数量,作为是否存在的判断
     *
     * @param typeName 分类名称
     * @return 存在的数量
     */
    long isExits(@Param("typeName") String typeName);
}
