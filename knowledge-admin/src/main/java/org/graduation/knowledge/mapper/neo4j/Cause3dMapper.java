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
public interface Cause3dMapper {

    /**
     * 初始化病因
     */
    void initCause();

    /**
     * 查询指定名字的病因的个数
     *
     * @param causeName 病因的名字
     * @return 个数
     */
    long isExits(@Param("causeName") String causeName);

    /**
     * 插入病因
     *
     * @param causeName 病因的名字
     */
    void insertCause(@Param("causeName") String causeName);
}
