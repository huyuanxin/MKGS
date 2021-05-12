package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 症状-传播途径
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface SpreadWay3dMapper {

    /**
     * 初始化SpreadWay,设置SpreadWay的name为唯一值
     */
    void initSpreadWay();

    /**
     * 插入传播途径
     *
     * @param spreadWayName 传播途径名称
     */
    void insertSpreadWay(@Param("spreadWayName") String spreadWayName);

    /**
     * 返回特定名称传播途径的数量,作为是否存在的判断
     *
     * @param spreadWayName 传播途径名称
     * @return 存在的数量
     */
    long isExits(@Param("spreadWayName") String spreadWayName);
}
