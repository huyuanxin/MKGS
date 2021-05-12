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
public interface AdjuvantTherapy3dMapper {

    /**
     * 初始化AdjuvantTherapy,设置AdjuvantTherapy的name为唯一值
     */
    void initAdjuvantTherapy();

    /**
     * 插入辅助治疗
     *
     * @param adjuvantTherapyName 辅助治疗名称
     */
    void insertAdjuvantTherapy(@Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 返回特定名称辅助治疗的数量,作为是否存在的判断
     *
     * @param adjuvantTherapyName 辅助治疗名称
     * @return 存在的数量
     */
    long isExits(@Param("adjuvantTherapyName") String adjuvantTherapyName);
}