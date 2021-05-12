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
public interface Infectious3dMapper {
    /**
     * 初始化传染性
     */
    void initInfectious();

    /**
     * 查询指定名字的传染性的个数
     *
     * @param infectiousName 传染性的名字
     * @return 个数
     */
    long isExits(@Param("infectiousName") String infectiousName);

    /**
     * 插入传染性
     *
     * @param infectiousName 传染性的名字
     */
    void insertInfectious(@Param("infectiousName") String infectiousName);
}
