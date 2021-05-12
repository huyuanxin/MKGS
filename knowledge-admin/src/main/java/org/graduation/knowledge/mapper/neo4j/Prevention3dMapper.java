package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 症状-预防
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Prevention3dMapper {

    /**
     * 初始化Prevention,设置Prevention的name为唯一值
     */
    void initPrevention();

    /**
     * 插入预防
     *
     * @param preventionName 预防名称
     */
    void insertPrevention(@Param("treatmentProgramsName") String preventionName);

    /**
     * 返回特定名称预防的数量,作为是否存在的判断
     *
     * @param preventionName 预防名称
     * @return 存在的数量
     */
    long isExits(@Param("preventionName") String preventionName);
}
