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
public interface Disease3dMapper {

    /**
     * 初始化Disease,设置Disease的name为唯一值
     */
    void initDisease();

    /**
     * 插入疾病
     *
     * @param diseaseName 疾病名称
     */
    void insertDisease(@Param("diseaseName") String diseaseName);

    /**
     * 返回特点名称疾病的数量,作为是否存在的判断
     *
     * @param diseaseName 疾病名称
     * @return 存在的数量
     */
    long isExits(@Param("diseaseName") String diseaseName);
}
