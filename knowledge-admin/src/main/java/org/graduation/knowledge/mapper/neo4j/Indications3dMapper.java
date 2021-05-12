package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 药物-适应症
 *
 * @author ztt
 */
@Mapper
@DS("3D")
@Repository
public interface Indications3dMapper {

    /**
     * 初始化Indications,设置Indications的name为唯一值
     */
    void initIndications();

    /**
     * 插入Indications
     *
     * @param indicationsName 适应症名称
     */
    void insertIndications(@Param("indicationsName") String indicationsName);

    /**
     * 返回特定名称适应症的数量,作为是否存在的判断
     *
     * @param indicationsName 适应症名称
     * @return 存在的数量
     */
    long isExits(@Param("indicationsName") String indicationsName);
}


