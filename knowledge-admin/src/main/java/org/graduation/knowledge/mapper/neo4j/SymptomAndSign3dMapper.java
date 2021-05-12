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
public interface SymptomAndSign3dMapper {

    /**
     * 初始化SymptomAndSign,设置SymptomAndSign的name为唯一值
     */
    void initSymptomAndSign();

    /**
     * 插入临床症状及体征
     *
     * @param symptomAndSignName 临床症状及体征名称
     */
    void insertSymptomAndSign(@Param("symptomAndSignName") String symptomAndSignName);

    /**
     * 返回特定名称临床症状及体征的数量,作为是否存在的判断
     *
     * @param symptomAndSignName 临床症状及体征名称
     * @return 存在的数量
     */
    long isExits(@Param("symptomAndSignName") String symptomAndSignName);
}