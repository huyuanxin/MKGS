package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Pathogenesis3dMapper {

    /**
     * 初始化Pathogenesis,设置Pathogenesis的name为唯一值
     */
    void initPathogenesis();

    /**
     * 插入发病机制
     *
     * @param pathogenesisName 发病机制名称
     */
    void insertPathogenesis(@Param("pathogenesisName") String pathogenesisName);

    /**
     * 返回特定名称发病机制的数量,作为是否存在的判断
     *
     * @param pathogenesisName 发病机制名称
     * @return 存在的数量
     */
    long isExits(@Param("pathogenesisName") String pathogenesisName);
}
