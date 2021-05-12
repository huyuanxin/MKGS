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
public interface DrugRelation3dMapper {
    /**
     * 插入成份关系
     *
     * @param drugName        药名
     * @param ingredientsName 成份名
     */
    void insertRelIngredientsDTI(@Param("drugName") String drugName, @Param("ingredientsName") String ingredientsName);

    /**
     * 插入OTC类型关系
     *
     * @param drugName 药名
     * @param OTCName  OTC类型名
     */
    void insertRelOTCDTO(@Param("drugName") String drugName, @Param("OTCName") String OTCName);

    /**
     * 插入不良反应关系
     *
     * @param drugName             药名
     * @param adverseReactionsName 不良反应名
     */
    void insertRelAdverseReactionsDTA(@Param("drugName") String drugName, @Param("adverseReactionsName") String adverseReactionsName);

    /**
     * 插入不良反应关系
     *
     * @param drugName    药名
     * @param diseaseName 疾病名
     */
    void insertRelAdverseReactionsDTD(@Param("drugName") String drugName, @Param("diseaseName") String diseaseName);

    /**
     * 插入不良反应关系
     *
     * @param drugName    药名
     * @param symptomName 症状名
     */
    void insertRelAdverseReactionsDTS(@Param("drugName") String drugName, @Param("symptomName") String symptomName);

    /**
     * 插入不良反应关系
     *
     * @param drugName         药名
     * @param complicationName 并发症名
     */
    void insertRelAdverseReactionsDTE(@Param("drugName") String drugName, @Param("complicationName") String complicationName);


    /**
     * 插入适应症关系
     *
     * @param drugName        药名
     * @param indicationsName 适应症名
     */
    void insertRelIndicationsDTI(@Param("drugName") String drugName, @Param("indicationsName") String indicationsName);

    /**
     * 插入适应症关系
     *
     * @param drugName    药名
     * @param diseaseName 疾病名
     */
    void insertRelIndicationsDTD(@Param("drugName") String drugName, @Param("diseaseName") String diseaseName);

    /**
     * 插入适应症关系
     *
     * @param drugName    药名
     * @param symptomName 症状名
     */
    void insertRelIndicationsDTS(@Param("drugName") String drugName, @Param("symptomName") String symptomName);

    /**
     * 插入适应症关系
     *
     * @param drugName         药名
     * @param complicationName 并发症名
     */
    void insertRelIndicationsDTE(@Param("drugName") String drugName, @Param("complicationName") String complicationName);

    /**
     * 插入分类关系
     *
     * @param drugName 药名
     * @param typeName 分类名称
     */
    void insertRelTypeDTT(@Param("drugName") String drugName, @Param("typeName") String typeName);

    /**
     * 插入注意事项关系
     *
     * @param drugName        药名
     * @param precautionsName 注意事项名称
     */
    void insertRelPrecautionsDTP(@Param("drugName") String drugName, @Param("precautionsName") String precautionsName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName              药名
     * @param contraindicationsName 禁忌证名称
     */
    void insertRelContraindicationsDTC(@Param("drugName") String drugName, @Param("contraindicationsName") String contraindicationsName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName    药名
     * @param diseaseName 疾病名
     */
    void insertRelContraindicationsDTD(@Param("drugName") String drugName, @Param("diseaseName") String diseaseName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName    药名
     * @param symptomName 症状名
     */
    void insertRelContraindicationsDTS(@Param("drugName") String drugName, @Param("symptomName") String symptomName);

    /**
     * 插入禁忌证关系
     *
     * @param drugName         药名
     * @param complicationName 并发症名
     */
    void insertRelContraindicationsDTE(@Param("drugName") String drugName, @Param("complicationName") String complicationName);

    /**
     * 插入所属科目关系
     *
     * @param drugName    药名
     * @param subjectName 所属科目名称
     */
    void insertRelSubjectDTS(@Param("drugName") String drugName, @Param("subjectName") String subjectName);
}
