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
public interface TreatmentRelation3dMapper {

    /**
     * 插入相关疾病关系
     *
     * @param treatmentName      诊疗名
     * @param relatedDiseaseName 相关疾病的名字
     */
    void insertRelRelatedDiseaseTTR(@Param("treatmentName") String treatmentName, @Param("relatedDiseaseName") String relatedDiseaseName);


    /**
     * 插入相关疾病关系
     *
     * @param treatmentName 诊疗名
     * @param diseaseName   疾病名
     */
    void insertRelRelatedDiseaseTTD(@Param("treatmentName") String treatmentName, @Param("diseaseName") String diseaseName);

    /**
     * 插入相关症状关系
     *
     * @param treatmentName      诊疗名
     * @param relatedSymptomName 相关症状名
     */
    void insertRelRelatedSymptomTTR(@Param("treatmentName") String treatmentName, @Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入相关症状关系
     *
     * @param treatmentName 诊疗名
     * @param symptomName   症状名
     */

    void insertRelRelatedDiseaseTTS(@Param("treatmentName") String treatmentName, @Param("symptomName") String symptomName);

    /**
     * 插入检查科目关系
     *
     * @param treatmentName    诊疗名
     * @param checkSubjectName 检查科目的名字
     */

    void insertRelCheckSubjectTTCS(@Param("treatmentName") String treatmentName, @Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入检查科目关系
     *
     * @param treatmentName 诊疗名
     * @param checkName     检查的名字
     */

    void insertRelCheckSubjectTTC(@Param("treatmentName") String treatmentName, @Param("checkName") String checkName);

    /**
     * 插入检查科目关系
     *
     * @param treatmentName            诊疗名
     * @param auxiliaryExaminationName 辅助检查的名字
     */

    void insertRelCheckSubjectTTA(@Param("treatmentName") String treatmentName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);
}
