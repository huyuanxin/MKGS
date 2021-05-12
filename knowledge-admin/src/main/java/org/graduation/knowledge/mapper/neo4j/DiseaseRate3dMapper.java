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
public interface DiseaseRate3dMapper {

    /**
     * 初始化DiseaseRate,设置DiseaseRate的name为唯一值
     */
    void initDiseaseRate();

    /**
     * 插入发病率
     *
     * @param diseaseRateName 发病率名称
     */
    void insertDiseaseRate(@Param("diseaseRateName") String diseaseRateName);

    /**
     * 返回特定名称发病率的数量,作为是否存在的判断
     *
     * @param diseaseRateName 发病率名称
     * @return 存在的数量
     */
    long isExits(@Param("diseaseRateName") String diseaseRateName);
}