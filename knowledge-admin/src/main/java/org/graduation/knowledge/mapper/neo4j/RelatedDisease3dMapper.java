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
public interface RelatedDisease3dMapper {
    /**
     * 初始化相关疾病
     */
    void initRelatedDisease();

    /**
     * 查询指定名字的相关疾病的个数
     *
     * @param relatedDiseaseName 相关疾病的名字
     * @return 个数
     */
    long isExits(@Param("relatedDiseaseName") String relatedDiseaseName);

    /**
     * 插入相关疾病
     *
     * @param relatedDiseaseName 相关疾病的名字
     */
    void insertRelatedDisease(@Param("relatedDiseaseName") String relatedDiseaseName);
}
