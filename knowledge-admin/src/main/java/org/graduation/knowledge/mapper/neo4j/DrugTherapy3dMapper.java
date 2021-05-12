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
public interface DrugTherapy3dMapper {

    /**
     * 初始化DrugTherapy,设置DrugTherapy的name为唯一值
     */
    void initDrugTherapy();

    /**
     * 插入药物治疗
     *
     * @param drugTherapyName 药物治疗名称
     */
    void insertDrugTherapy(@Param("drugTherapyName") String drugTherapyName);

    /**
     * 返回特点名称药物治疗的数量,作为是否存在的判断
     *
     * @param drugTherapyName 药物治疗名称
     * @return 存在的数量
     */
    long isExits(@Param("drugTherapyName") String drugTherapyName);
}