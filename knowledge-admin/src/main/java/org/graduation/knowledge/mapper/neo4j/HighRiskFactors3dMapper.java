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
public interface HighRiskFactors3dMapper {

    /**
     * 初始化高危因素
     */
    void initHighRiskFactors();

    /**
     * 查询指定名字的高危因素的个数
     *
     * @param highRiskFactorsName 高危因素的名字
     * @return 个数
     */
    long isExits(@Param("highRiskFactorsName") String highRiskFactorsName);

    /**
     * 插入高危因素
     *
     * @param highRiskFactorsName 高危因素的名字
     */
    void insertHighRiskFactors(@Param("highRiskFactorsName") String highRiskFactorsName);

}
