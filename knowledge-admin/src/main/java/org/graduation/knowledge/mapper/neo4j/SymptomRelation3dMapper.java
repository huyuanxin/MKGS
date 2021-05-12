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
public interface SymptomRelation3dMapper {
    /**
     * 插入病因关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    void insertRelCauseSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入病因关系
     *
     * @param symptomName 症状名
     * @param causeName   病因名
     */
    void insertRelCauseSTC(@Param("symptomName") String symptomName, @Param("causeName") String causeName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName         症状名
     * @param adjuvantTherapyName 辅助治疗名
     */
    void insertRelTreatmentProgramsSTA(@Param("symptomName") String symptomName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName     症状名
     * @param drugTherapyName 药物治疗名
     */
    void insertRelTreatmentProgramsSTU(@Param("symptomName") String symptomName, @Param("drugTherapyName") String drugTherapyName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName   症状名
     * @param operationName 手术治疗名
     */
    void insertRelTreatmentProgramsSTO(@Param("symptomName") String symptomName, @Param("operationName") String operationName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName 症状名
     * @param drugName    药名
     */
    void insertRelTreatmentProgramsSTD(@Param("symptomName") String symptomName, @Param("drugName") String drugName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName   症状名
     * @param treatmentName 诊疗名
     */
    void insertRelTreatmentProgramsSTT(@Param("symptomName") String symptomName, @Param("treatmentName") String treatmentName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName 症状名
     * @param checkName   检查名
     */
    void insertRelTreatmentProgramsSTC(@Param("symptomName") String symptomName, @Param("checkName") String checkName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName              症状名
     * @param auxiliaryExaminationName 辅助检查名
     */
    void insertRelTreatmentProgramsSTE(@Param("symptomName") String symptomName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入治疗方案关系
     *
     * @param symptomName           症状名
     * @param treatmentProgramsName 治疗方案名
     */
    void insertRelTreatmentProgramsSTTP(@Param("symptomName") String symptomName, @Param("treatmentProgramsName") String treatmentProgramsName);

    /**
     * 插入预防关系
     *
     * @param symptomName    症状名
     * @param preventionName 预防名
     */
    void insertRelPreventionSTP(@Param("symptomName") String symptomName, @Param("preventionName") String preventionName);

    /**
     * 插入传播途径关系
     *
     * @param symptomName   症状名
     * @param spreadWayName 传播途径名
     */
    void insertRelSpreadWaySTSW(@Param("symptomName") String symptomName, @Param("spreadWayName") String spreadWayName);

    /**
     * 插入检查关系
     *
     * @param symptomName 症状名
     * @param checkName   检查名
     */
    void insertRelCheckSTC(@Param("symptomName") String symptomName, @Param("checkName") String checkName);

    /**
     * 插入检查关系
     *
     * @param symptomName              症状名
     * @param auxiliaryExaminationName 辅助检查名
     */
    void insertRelCheckSTA(@Param("symptomName") String symptomName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入检查关系
     *
     * @param symptomName      症状名
     * @param checkSubjectName 检查科目名
     */
    void insertRelCheckSTCS(@Param("symptomName") String symptomName, @Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入所属科室关系
     *
     * @param symptomName    症状名
     * @param departmentName 所属科室名
     */
    void insertRelDepartment(@Param("symptomName") String symptomName, @Param("departmentName") String departmentName);

    /**
     * 插入发病部位关系
     *
     * @param symptomName     症状名
     * @param diseaseSiteName 发病部位名
     */
    void insertRelDiseaseSiteSTDS(@Param("symptomName") String symptomName, @Param("diseaseSiteName") String diseaseSiteName);

    /**
     * 插入发病部位关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    void insertRelDiseaseSiteSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入发病部位关系
     *
     * @param symptomNameA 症状名
     * @param symptomNameB 症状名
     */
    void insertRelDiseaseSiteSTS(@Param("symptomNameA") String symptomNameA, @Param("symptomNameB") String symptomNameB);

    /**
     * 插入相关疾病关系
     *
     * @param symptomName        症状名
     * @param relatedDiseaseName 相关疾病名
     */
    void insertRelRelatedDiseaseSTR(@Param("symptomName") String symptomName, @Param("relatedDiseaseName") String relatedDiseaseName);

    /**
     * 插入相关疾病关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    void insertRelRelatedDiseaseSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入相关症状关系
     *
     * @param symptomNameA 症状名
     * @param symptomNameB 症状名
     */
    void insertRelRelatedSymptomSTS(@Param("symptomNameA") String symptomNameA, @Param("symptomNameB") String symptomNameB);

    /**
     * 插入相关疾病关系
     *
     * @param symptomName        症状名
     * @param relatedSymptomName 相关疾病名
     */
    void insertRelRelatedSymptomSTR(@Param("symptomName") String symptomName, @Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入病理分型关系
     *
     * @param symptomName          症状名
     * @param pathologicalTypeName 病理分型名
     */
    void insertRelPathologicalType(@Param("symptomName") String symptomName, @Param("pathologicalTypeName") String pathologicalTypeName);

    /**
     * 插入辅助治疗关系
     *
     * @param symptomName         症状名
     * @param adjuvantTherapyName 辅助治疗名
     */
    void insertRelAdjuvantTherapySTA(@Param("symptomName") String symptomName, @Param("adjuvantTherapyName") String adjuvantTherapyName);

    /**
     * 插入辅助治疗关系
     *
     * @param symptomName   症状名
     * @param treatmentName 诊疗名
     */
    void insertRelAdjuvantTherapySTT(@Param("symptomName") String symptomName, @Param("treatmentName") String treatmentName);

    /**
     * 插入传染性关系
     *
     * @param symptomName    症状名
     * @param infectiousName 诊疗名
     */
    void insertRelInfectious(@Param("symptomName") String symptomName, @Param("infectiousName") String infectiousName);

    /**
     * 插入并发症关系
     *
     * @param symptomAName 症状名A
     * @param symptomBName 症状名B
     */
    void insertRelComplicationSTS(@Param("symptomAName") String symptomAName, @Param("symptomBName") String symptomBName);

    /**
     * 插入并发症关系
     *
     * @param symptomName 症状名
     * @param diseaseName 疾病名
     */
    void insertRelComplicationSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入并发症关系
     *
     * @param symptomName      症状名
     * @param complicationName 并发症名
     */
    void insertRelComplicationSTC(@Param("symptomName") String symptomName, @Param("complicationName") String complicationName);

    /**
     * 插入相关导致关系
     *
     * @param symptomName   症状名
     * @param relatedToName 并发症名
     */
    void insertRelRelatedTo(@Param("symptomName") String symptomName, @Param("relatedToName") String relatedToName);

    /**
     * 插入疾病实体 临床症状及体征
     *
     * @param symptomName 症状名A
     * @param diseaseName 疾病实体  临床症状及体征名
     */
    void insertRelSymptomAndSignSTD(@Param("symptomName") String symptomName, @Param("diseaseName") String diseaseName);

    /**
     * 插入症状实体 临床症状及体征
     *
     * @param symptomAName 症状名
     * @param symptomBName 症状名B
     */
    void insertRelSymptomAndSignSTS(@Param("symptomAName") String symptomAName, @Param("symptomBName") String symptomBName);

    /**
     * 插入临床症状及体征实体 临床症状及体征
     *
     * @param symptomName        症状名
     * @param symptomAndSignName 临床症状及体征实体 临床症状及体征名
     */
    void insertRelSymptomAndSignSTSAS(@Param("symptomName") String symptomName, @Param("symptomAndSignName") String symptomAndSignName);

    /**
     * 插入辅助检查关系
     *
     * @param symptomName 症状名
     * @param checkName   检查名
     */
    void insertRelAuxiliaryExaminationSTC(@Param("symptomName") String symptomName, @Param("checkName") String checkName);

    /**
     * 插入辅助检查关系
     *
     * @param symptomName              症状名
     * @param auxiliaryExaminationName 辅助检查名
     */
    void insertRelAuxiliaryExaminationSTA(@Param("symptomName") String symptomName, @Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 插入辅助检查关系
     *
     * @param symptomName      症状名
     * @param checkSubjectName 检查科目名
     */
    void insertRelAuxiliaryExaminationSTCS(@Param("symptomName") String symptomName, @Param("checkSubjectName") String checkSubjectName);

    /**
     * 插入药名实体 药物治疗
     *
     * @param symptomName 症状名
     * @param drugName    药名实体 药物治疗名
     */
    void insertRelDrugTherapySTD(@Param("symptomName") String symptomName, @Param("drugName") String drugName);

    /**
     * 插入药物治疗实体 药物治疗
     *
     * @param symptomName     症状名
     * @param drugTherapyName 药物治疗实体 药物治疗名
     */
    void insertRelDrugTherapySTDT(@Param("symptomName") String symptomName, @Param("drugTherapyName") String drugTherapyName);

    /**
     * 插入阶段实体 阶段
     *
     * @param symptomName 症状名
     * @param stageName   阶段实体 阶段名
     */
    void insertRelStage(@Param("symptomName") String symptomName, @Param("stageName") String stageName);

    /**
     * 插入多发群体实体 多发群体
     *
     * @param symptomName        症状名
     * @param multipleGroupsName 多发群体实体 多发群体名
     */
    void insertRelMultipleGroups(@Param("symptomName") String symptomName, @Param("multipleGroupsName") String multipleGroupsName);

}
