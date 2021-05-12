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
public interface Drug3dMapper {

    /**
     * 初始化Drug,设置Drug的name为唯一值
     */
    void initDrug();

    /**
     * 插入疾病
     *
     * @param drugName 药品名称
     */
    void insertDrug(@Param("drugName") String drugName);

    /**
     * 返回特点名称药品的数量,作为是否存在的判断
     *
     * @param drugName 药品名称
     * @return 存在的数量
     */
    long isExits(@Param("drugName") String drugName);
}
