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
public interface Operation3dMapper {

    /**
     * 初始化Operation,设置Operation的name为唯一值
     */
    void initOperation();

    /**
     * 插入手术治疗
     *
     * @param operationTherapyName 手术治疗名称
     */
    void insertOperation(@Param("operationTherapyName") String operationTherapyName);

    /**
     * 返回特定名称手术治疗的数量,作为是否存在的判断
     *
     * @param operationTherapyName 手术治疗名称
     * @return 存在的数量
     */
    long isExits(@Param("operationTherapyName") String operationTherapyName);
}