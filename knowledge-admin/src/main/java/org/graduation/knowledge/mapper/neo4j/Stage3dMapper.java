package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 症状-阶段
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Stage3dMapper {

    /**
     * 初始化Stage,设置Stage的name为唯一值
     */
    void initStage();

    /**
     * 插入阶段
     *
     * @param stageName 阶段名称
     */
    void insertStage(@Param("stageName") String stageName);

    /**
     * 返回特定名称阶段的数量,作为是否存在的判断
     *
     * @param stageName 阶段名称
     * @return 存在的数量
     */
    long isExits(@Param("stageName") String stageName);
}
