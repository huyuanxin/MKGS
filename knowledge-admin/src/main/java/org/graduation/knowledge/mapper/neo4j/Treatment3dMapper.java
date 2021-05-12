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
public interface Treatment3dMapper {

    /**
     * 初始化Treatment,设置Treatment的name为唯一值
     */
    void initTreatment();

    /**
     * 插入诊疗
     *
     * @param treatmentName 名称
     */
    void insertTreatment(@Param("treatmentName") String treatmentName);

    /**
     * 返回特点名称诊疗的数量,作为是否存在的判断
     *
     * @param treatmentName 诊疗名称
     * @return 存在的数量
     */
    long isExits(@Param("treatmentName") String treatmentName);
}
