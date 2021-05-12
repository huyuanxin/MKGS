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
public interface Complication3dMapper {

    /**
     * 初始化并发症
     */
    void initComplication();

    /**
     * 查询指定名字的并发症的个数
     *
     * @param complicationName 并发症的名字
     * @return 个数
     */
    long isExits(@Param("complicationName") String complicationName);

    /**
     * 插入并发症
     *
     * @param complicationName 并发症的名字
     */
    void insertComplication(@Param("complicationName") String complicationName);
}
