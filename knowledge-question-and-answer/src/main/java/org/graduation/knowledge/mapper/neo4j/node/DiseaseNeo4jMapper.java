package org.graduation.knowledge.mapper.neo4j.node;


import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.graduation.knowledge.model.node.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("QA")
public interface DiseaseNeo4jMapper {

    /**
     * 查询疾病有哪些症状
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病有哪些症状
     */
    List<Symptom> getSymptomByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病的并发症
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的并发症
     */
    List<Disease> getAccompanyByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 反向查询疾病的并发症,即是diseaseAccompany的反向查询
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的并发症
     */
    List<Disease> getAccompanyReverseByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病的忌口
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的忌口
     */
    List<Food> getNotEatFoodByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病建议吃的食物
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病建议吃的东西
     */
    List<Food> getRecommendFoodByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病建议吃的食谱
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病建议吃的东西
     */
    List<Food> getRecommendRecipeByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病常用药品－药品别名记得扩充
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病常用药品－药品别名记得扩充
     */
    List<Drug> getCommonDrugByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病推荐药品－药品别名记得扩充
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病常用药品－药品别名记得扩充
     */
    List<Drug> getRecommendDrugByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病应该进行的检查
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病应该进行的检查
     */
    List<Check> getCheckByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 查询疾病的相关介绍
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的相关介绍
     */
    Disease getDiseaseByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 获得指定名称疾病的数量，用来判断是否存在
     *
     * @param name 检查的名称
     * @return 数量
     */
    Long countByName(@Param("name") String name);
}
