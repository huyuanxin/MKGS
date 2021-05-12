package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 药物-OTC类型
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface OTC3dMapper {

    /**
     * 初始化OTC,设置OTC的name为唯一值
     */
    void initOTC();

    /**
     * 插入OTC
     *
     * @param OTCName OTC名称
     */
    void insertOTC(@Param("OTCName") String OTCName);

    /**
     * 返回特定名称OTC类型的数量,作为是否存在的判断
     *
     * @param OTCName 成份名称
     * @return 存在的数量
     */
    long isExits(@Param("OTCName") String OTCName);
}

