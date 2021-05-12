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
public interface MultipleGroups3dMapper {

    /**
     * 初始化多发群体
     */
    void initMultipleGroups();

    /**
     * 查询指定名字的多发群体的个数
     *
     * @param multipleGroupsName 多发群体的名字
     * @return 个数
     */
    long isExits(@Param("multipleGroupsName") String multipleGroupsName);

    /**
     * 插入多发群体
     *
     * @param multipleGroupsName 多发群体的名字
     */
    void insertMultipleGroups(@Param("multipleGroupsName") String multipleGroupsName);
}
