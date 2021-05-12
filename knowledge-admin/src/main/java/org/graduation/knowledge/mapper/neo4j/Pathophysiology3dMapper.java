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
public interface Pathophysiology3dMapper {
    /**
     * 初始化病理生理
     */
    void initPathophysiology();

    /**
     * 查询指定名字的病理生理的个数
     *
     * @param pathophysiologyName 病理生理的名字
     * @return 个数
     */
    long isExits(@Param("pathophysiologyName") String pathophysiologyName);

    /**
     * 插入病理生理
     *
     * @param pathophysiologyName 病理生理的名字
     */
    void insertPathophysiology(@Param("pathophysiologyName") String pathophysiologyName);
}
