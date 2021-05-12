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
public interface DiseaseRelation3dMapper {
    /**
     * 插入并发症关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    void insertRelComplicationDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入并发症关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */
    void insertRelComplicationDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入并发症关系
     *
     * @param diseaseName      疾病名
     * @param complicationName 并发症名
     */
    void insertRelComplicationDTC(@Param("diseaseName") String diseaseName, @Param("complicationName") String complicationName);

    /**
     * 插入病理生理关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    void insertRelPathophysiologyDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入病理生理关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */
    void insertRelPathophysiologyDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入病理生理关系
     *
     * @param diseaseName         疾病名
     * @param pathophysiologyName 病理生理名
     */
    void insertRelPathophysiologyDTP(@Param("diseaseName") String diseaseName, @Param("pathophysiologyName") String pathophysiologyName);

    /**
     * 插入发病部位关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    void insertRelDiseaseSiteDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入发病部位关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */
    void insertRelDiseaseSiteDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);


    /**
     * 插入发病部位关系
     *
     * @param diseaseName     疾病名
     * @param diseaseSiteName 发病部位名
     */
    void insertRelDiseaseSiteDTP(@Param("diseaseName") String diseaseName, @Param("diseaseSiteName") String diseaseSiteName);

    /**
     * 插入所属科室关系
     *
     * @param diseaseName    疾病名
     * @param departmentName 所属科室名
     */
    void insertRelDepartmentDTD(@Param("diseaseName") String diseaseName, @Param("departmentName") String departmentName);

    /**
     * 插入多发群体关系
     *
     * @param diseaseName        疾病名
     * @param multipleGroupsName 所属科室名
     */
    void insertRelMultipleGroupsDTM(@Param("diseaseName") String diseaseName, @Param("multipleGroupsName") String multipleGroupsName);

    /**
     * 插入病因关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    void insertRelCauseDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入病因关系
     *
     * @param diseaseName 疾病名
     * @param causeName   病因名
     */
    void insertRelCauseDTC(@Param("diseaseName") String diseaseName, @Param("causeName") String causeName);

    /**
     * 插入预后生存时间关系
     *
     * @param diseaseName                疾病名
     * @param prognosticSurvivalTimeName 预后生存时间名
     */
    void insertRelPrognosticSurvivalTimeDTP(@Param("diseaseName") String diseaseName, @Param("prognosticSurvivalTimeName") String prognosticSurvivalTimeName);

    /**
     * 插入高危因素关系
     *
     * @param diseaseName         疾病名
     * @param highRiskFactorsName 高危因素名
     */
    void insertRelHighRiskFactorsDTH(@Param("diseaseName") String diseaseName, @Param("highRiskFactorsName") String highRiskFactorsName);

    /**
     * 插入相关疾病关系
     *
     * @param diseaseAName 疾病名A
     * @param diseaseBName 疾病名B
     */
    void insertRelRelatedDiseaseDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入相关疾病关系
     *
     * @param diseaseName        疾病名
     * @param relatedDiseaseName 相关疾病名
     */
    void insertRelRelatedDiseaseDTR(@Param("diseaseName") String diseaseName, @Param("relatedDiseaseName") String relatedDiseaseName);

    /**
     * 插入相关症状关系
     *
     * @param diseaseName        疾病名
     * @param relatedSymptomName 相关症状名
     */
    void insertRelRelatedSymptomDTR(@Param("diseaseName") String diseaseName, @Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入相关症状关系
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状名
     */
    void insertRelRelatedSymptomDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName         疾病名
     * @param adjuvantTherapyName 辅助治疗名
     */
    void insertRelTreatmentProgramsDTA(@Param("diseaseName") String diseaseName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName     疾病名
     * @param drugTherapyName 药物治疗名
     */
    void insertRelTreatmentProgramsDTU(@Param("diseaseName") String diseaseName, @Param("drugTherapyName") String drugTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName   疾病名
     * @param operationName 手术治疗名
     */
    void insertRelTreatmentProgramsDTO(@Param("diseaseName") String diseaseName, @Param("operationName") String operationName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName 疾病名
     * @param drugName    药名
     */
    void insertRelTreatmentProgramsDTD(@Param("diseaseName") String diseaseName, @Param("drugName") String drugName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName   疾病名
     * @param treatmentName 诊疗名
     */
    void insertRelTreatmentProgramsDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName 疾病名
     * @param checkName   检查名
     */
    void insertRelTreatmentProgramsDTC(@Param("diseaseName") String diseaseName, @Param("checkName") String checkName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName              疾病名
     * @param auxiliaryExaminationName 辅助检查名
     */
    void insertRelTreatmentProgramsDTE(@Param("diseaseName") String diseaseName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入治疗方案关系
     *
     * @param diseaseName           疾病名
     * @param treatmentProgramsName 治疗方案名
     */
    void insertRelTreatmentProgramsDTTP(@Param("diseaseName") String diseaseName, @Param("treatmentProgramsName") String treatmentProgramsName);


//临床症状及体征

    /**
     * 插入疾病实体 临床症状及体征
     *
     * @param diseaseAName 疾病名
     * @param diseaseBName 疾病实体 临床症状及体征名
     */
    void insertRelSymptomAndSignDTD(@Param("diseaseAName") String diseaseAName, @Param("diseaseBName") String diseaseBName);

    /**
     * 插入症状实体并发症
     *
     * @param diseaseName 疾病名
     * @param symptomName 症状实体 临床症状及体征名
     */
    void insertRelSymptomAndSignDTS(@Param("diseaseName") String diseaseName, @Param("symptomName") String symptomName);

    /**
     * 插入临床症状及体征实体 临床症状及体征
     *
     * @param diseaseName        疾病名
     * @param symptomAndSignName 临床症状及体征实体 临床症状及体征名
     */
    void insertRelSymptomAndSignDTSAS(@Param("diseaseName") String diseaseName, @Param("symptomAndSignName") String symptomAndSignName);

    //预后状况

    /**
     * 插入预后状况实体 预后状况
     *
     * @param diseaseName   疾病名
     * @param prognosisName 预后状况实体 预后状况名
     */
    void insertRelPrognosis(@Param("diseaseName") String diseaseName, @Param("prognosisName") String prognosisName);

    //发病率

    /**
     * 插入属性实体 发病率
     *
     * @param diseaseName   疾病名
     * @param attributeName 症状实体 发病率名
     */
    void insertRelDiseaseRateDTA(@Param("diseaseName") String diseaseName, @Param("attributeName") String attributeName);

    /**
     * 插入发病率实体 发病率
     *
     * @param diseaseName     疾病名
     * @param diseaseRateName 发病率实体 发病率名
     */
    void insertRelDiseaseRateDTDR(@Param("diseaseName") String diseaseName, @Param("diseaseRateName") String diseaseRateName);

    //药物治疗

    /**
     * 插入属性实体 药物治疗
     *
     * @param diseaseName 疾病名
     * @param drugName    属性实体 药物治疗名
     */
    void insertRelDrugTherapyDTD(@Param("diseaseName") String diseaseName, @Param("drugName") String drugName);

    /**
     * 插入药物治疗实体 发病率
     *
     * @param diseaseName     疾病名
     * @param drugTherapyName 药物治疗实体 药物治疗名
     */
    void insertRelDrugTherapyDTDT(@Param("diseaseName") String diseaseName, @Param("drugTherapyName") String drugTherapyName);

    //辅助治疗

    /**
     * 插入症状实体 辅助治疗
     *
     * @param diseaseName   疾病名
     * @param treatmentName 药品实体 药物治疗名
     */
    void insertRelAdjuvantTherapyDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入药物治疗实体 辅助治疗
     *
     * @param diseaseName         疾病名
     * @param adjuvantTherapyName 药物治疗实体 药物治疗名
     */
    void insertRelAdjuvantTherapyDTA(@Param("diseaseName") String diseaseName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    //手术治疗

    /**
     * 插入症状实体 手术治疗
     *
     * @param diseaseName   疾病名
     * @param treatmentName 药品实体 药物治疗名
     */
    void insertRelOperationDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入手术治疗实体 手术治疗
     *
     * @param diseaseName   疾病名
     * @param operationName 药物治疗实体 药物治疗名
     */
    void insertRelOperationDTO(@Param("diseaseName") String diseaseName, @Param("operationName") String operationName);

    //发病机制

    /**
     * 插入发病机制实体 发病机制
     *
     * @param diseaseName      疾病名
     * @param pathogenesisName 发病机制实体 发病机制名
     */
    void insertRelPathogenesisDTO(@Param("diseaseName") String diseaseName, @Param("pathogenesisName") String pathogenesisName);

    //病理分型

    /**
     * 插入病理分型实体 病理分型
     *
     * @param diseaseName          疾病名
     * @param pathologicalTypeName 病理分型实体 病理分型名
     */
    void insertRelPathologicalTypeDTO(@Param("diseaseName") String diseaseName, @Param("pathologicalTypeName") String pathologicalTypeName);

    //鉴别诊断

    /**
     * 插入诊疗实体 鉴别诊断
     *
     * @param diseaseName   疾病名
     * @param treatmentName 诊疗实体 鉴别诊断名
     */
    void insertRelDiagnosisDTT(@Param("diseaseName") String diseaseName, @Param("treatmentName") String treatmentName);

    /**
     * 插入鉴别诊断实体 鉴别诊断
     *
     * @param diseaseName   疾病名
     * @param diagnosisName 鉴别诊断实体 鉴别诊断名
     */
    void insertRelDiagnosisDTDI(@Param("diseaseName") String diseaseName, @Param("diagnosisName") String diagnosisName);

}
