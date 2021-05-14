package org.graduation.knowledge.util;

import java.util.LinkedHashMap;

/**
 * @author huyuanxin
 */
public class DiseaseRelationUtil {

    private static volatile DiseaseRelationUtil instance = null;
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndDisease = new LinkedHashMap<>(16);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndSymptom = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndComplication = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndPathophysiology = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndDiseaseSite = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndDepartment = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndMultipleGroups = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndPrognosticSurvivalTime = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndHighRiskFactors = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndRelatedDisease = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndRelatedSymptom = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndAdjuvantTherapy = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndDrugTherapy = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndOperation = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndTreatment = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndCheck = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndAuxiliaryExamination = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndTreatmentPrograms = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndSymptomAndSign = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndPrognosis = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndAttribute = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndDrug = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndPathogenesis = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndPathologicalType = new LinkedHashMap<>(8);
    public final LinkedHashMap<String, String> relationsBetweenDiseaseAndDiagnosis = new LinkedHashMap<>(8);

    private DiseaseRelationUtil() {
        init();
    }

    public static DiseaseRelationUtil getInstance() {
        if (instance == null) {
            synchronized (RelationUtil.class) {
                if (instance == null) {
                    instance = new DiseaseRelationUtil();
                }
            }
        }
        return instance;
    }

    public void init() {
        initRelationsBetweenDiseaseAndDisease();
        initRelationsBetweenDiseaseAndSymptom();
        initRelationsBetweenDiseaseAndComplication();
        initRelationsBetweenDiseaseAndPathophysiology();
        initRelationsBetweenDiseaseAndDiseaseSite();
        initRelationsBetweenDiseaseAndDepartment();
        initRelationsBetweenDiseaseAndMultipleGroups();
        initRelationsBetweenDiseaseAndPrognosticSurvivalTime();
        initRelationsBetweenDiseaseAndHighRiskFactors();
        initRelationsBetweenDiseaseAndRelatedDisease();
        initRelationsBetweenDiseaseAndRelatedSymptom();
        initRelationsBetweenDiseaseAndAdjuvantTherapy();
        initRelationsBetweenDiseaseAndDrugTherapy();
        initRelationsBetweenDiseaseAndAuxiliaryExamination();
        initRelationsBetweenDiseaseAndCheck();
        initRelationsBetweenDiseaseAndTreatment();
        initRelationsBetweenDiseaseAndOperation();
        initRelationsBetweenDiseaseAndTreatmentPrograms();
        initRelationsBetweenDiseaseAndAttribute();
        initRelationsBetweenDiseaseAndPrognosis();
        initRelationsBetweenDiseaseAndSymptomAndSign();
        initRelationsBetweenDiseaseAndDiagnosis();
        initRelationsBetweenDiseaseAndPathologicalType();
        initRelationsBetweenDiseaseAndPathogenesis();
        initRelationsBetweenDiseaseAndDrug();

    }

    private void initRelationsBetweenDiseaseAndDisease() {
        relationsBetweenDiseaseAndDisease.put("并发症", "complication");
        relationsBetweenDiseaseAndDisease.put("病理生理", "pathophysiology");
        relationsBetweenDiseaseAndDisease.put("发病部位", "diseaseSite");
        relationsBetweenDiseaseAndDisease.put("病因", "cause");
        relationsBetweenDiseaseAndDisease.put("相关疾病", "relatedDisease");
        relationsBetweenDiseaseAndDisease.put("临床症状及体征", "symptomAndSign");
    }

    private void initRelationsBetweenDiseaseAndSymptom() {
        relationsBetweenDiseaseAndSymptom.put("并发症", "complication");
        relationsBetweenDiseaseAndSymptom.put("病理生理", "pathophysiology");
        relationsBetweenDiseaseAndSymptom.put("发病部位", "diseaseSite");
        relationsBetweenDiseaseAndSymptom.put("相关症状", "relatedSymptom");
        relationsBetweenDiseaseAndSymptom.put("临床症状及体征", "symptomAndSign");
    }

    private void initRelationsBetweenDiseaseAndComplication() {
        relationsBetweenDiseaseAndComplication.put("并发症", "complication");
    }

    private void initRelationsBetweenDiseaseAndPathophysiology() {
        relationsBetweenDiseaseAndPathophysiology.put("并发症", "complication");
    }

    private void initRelationsBetweenDiseaseAndDiseaseSite() {
        relationsBetweenDiseaseAndDiseaseSite.put("发病部位", "diseaseSite");
    }

    private void initRelationsBetweenDiseaseAndDepartment() {
        relationsBetweenDiseaseAndDepartment.put("科室", "department");
    }

    private void initRelationsBetweenDiseaseAndMultipleGroups() {
        relationsBetweenDiseaseAndMultipleGroups.put("群体关系", "multipleGroups");
    }

    private void initRelationsBetweenDiseaseAndPrognosticSurvivalTime() {
        relationsBetweenDiseaseAndPrognosticSurvivalTime.put("预后生存时间", "prognosticSurvivalTime");
    }

    private void initRelationsBetweenDiseaseAndHighRiskFactors() {
        relationsBetweenDiseaseAndHighRiskFactors.put("高危因素", "highRiskFactors");
    }

    private void initRelationsBetweenDiseaseAndRelatedDisease() {
        relationsBetweenDiseaseAndRelatedDisease.put("相关疾病", "relatedDisease");
    }

    private void initRelationsBetweenDiseaseAndRelatedSymptom() {
        relationsBetweenDiseaseAndRelatedSymptom.put("相关症状", "relatedSymptom");
    }

    private void initRelationsBetweenDiseaseAndAdjuvantTherapy() {
        relationsBetweenDiseaseAndAdjuvantTherapy.put("治疗方案", "treatmentPrograms");
        relationsBetweenDiseaseAndAdjuvantTherapy.put("辅助治疗", "adjuvantTherapy");

    }

    private void initRelationsBetweenDiseaseAndDrugTherapy() {
        relationsBetweenDiseaseAndDrugTherapy.put("治疗方案", "treatmentPrograms");
        relationsBetweenDiseaseAndDrugTherapy.put("发病率", "diseaseRate");
    }

    private void initRelationsBetweenDiseaseAndOperation() {
        relationsBetweenDiseaseAndOperation.put("治疗方案", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndTreatment() {
        relationsBetweenDiseaseAndTreatment.put("治疗方案", "treatmentPrograms");
        relationsBetweenDiseaseAndTreatment.put("辅助治疗", "adjuvantTherapy");
    }

    private void initRelationsBetweenDiseaseAndCheck() {
        relationsBetweenDiseaseAndCheck.put("治疗方案", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndAuxiliaryExamination() {
        relationsBetweenDiseaseAndAuxiliaryExamination.put("治疗方案", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndTreatmentPrograms() {
        relationsBetweenDiseaseAndTreatmentPrograms.put("治疗方案", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndSymptomAndSign() {
        relationsBetweenDiseaseAndSymptomAndSign.put("临床症状及体征", "symptomAndSign");
    }

    private void initRelationsBetweenDiseaseAndPrognosis() {
        relationsBetweenDiseaseAndPrognosis.put("预后状况实体", "prognosis");
    }

    private void initRelationsBetweenDiseaseAndAttribute() {
        relationsBetweenDiseaseAndAttribute.put("发病率", "diseaseRate");
    }

    private void initRelationsBetweenDiseaseAndDrug() {
        relationsBetweenDiseaseAndDrug.put("药物治疗", "drugTherapy");
    }

    private void initRelationsBetweenDiseaseAndPathogenesis() {
        relationsBetweenDiseaseAndPathogenesis.put("发病机制", "pathogenesis");
    }

    private void initRelationsBetweenDiseaseAndPathologicalType() {
        relationsBetweenDiseaseAndPathologicalType.put("病理分型", "pathologicalType");
    }

    private void initRelationsBetweenDiseaseAndDiagnosis() {
        relationsBetweenDiseaseAndDiagnosis.put("鉴别诊断", "diagnosis");
    }

}
