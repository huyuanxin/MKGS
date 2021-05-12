package org.graduation.knowledge.service;

import org.graduation.knowledge.model.node.*;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface DiseaseService {

    /**
     * 通过病名查询疾病实体
     *
     * @param diseaseName 疾病的名称
     * @return 疾病
     */
    Disease getDiseaseByDiseaseName(String diseaseName);

    /**
     * 查询疾病有哪些症状
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病有哪些症状
     */
    List<Symptom> getSymptomByDiseaseName(String diseaseName);

    /**
     * 查询疾病的并发症
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的并发症
     */
    List<Disease> getAccompanyByDiseaseName(String diseaseName);

    /**
     * 查询疾病的并发症
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的并发症
     */
    List<Disease> getAccompanyReverseByDiseaseName(String diseaseName);


    /**
     * 查询疾病的忌口
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病的忌口
     */
    List<Food> getNotEatFoodByDiseaseName(String diseaseName);

    /**
     * 查询疾病建议吃的东西
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病建议吃的东西
     */
    List<Food> getRecommendFoodByDiseaseName(String diseaseName);

    /**
     * 查询疾病建议吃的东西
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病建议吃的东西
     */
    List<Food> getRecommendRecipeByDiseaseName(String diseaseName);

    /**
     * 查询疾病常用药品－药品别名记得扩充
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病常用药品－药品别名记得扩充
     */
    List<Drug> getCommonDrugByDiseaseName(String diseaseName);

    /**
     * 查询疾病常用药品－药品别名记得扩充
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病常用药品－药品别名记得扩充
     */
    List<Drug> getRecommendDrugByDiseaseName(String diseaseName);

    /**
     * 查询疾病应该进行的检查
     *
     * @param diseaseName 疾病的名称
     * @return 查询疾病应该进行的检查
     */
    List<Check> getCheckByDiseaseName(String diseaseName);
}
