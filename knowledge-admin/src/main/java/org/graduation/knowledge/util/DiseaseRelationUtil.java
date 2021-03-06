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
        relationsBetweenDiseaseAndDisease.put("?????????", "complication");
        relationsBetweenDiseaseAndDisease.put("????????????", "pathophysiology");
        relationsBetweenDiseaseAndDisease.put("????????????", "diseaseSite");
        relationsBetweenDiseaseAndDisease.put("??????", "cause");
        relationsBetweenDiseaseAndDisease.put("????????????", "relatedDisease");
        relationsBetweenDiseaseAndDisease.put("?????????????????????", "symptomAndSign");
    }

    private void initRelationsBetweenDiseaseAndSymptom() {
        relationsBetweenDiseaseAndSymptom.put("?????????", "complication");
        relationsBetweenDiseaseAndSymptom.put("????????????", "pathophysiology");
        relationsBetweenDiseaseAndSymptom.put("????????????", "diseaseSite");
        relationsBetweenDiseaseAndSymptom.put("????????????", "relatedSymptom");
        relationsBetweenDiseaseAndSymptom.put("?????????????????????", "symptomAndSign");
    }

    private void initRelationsBetweenDiseaseAndComplication() {
        relationsBetweenDiseaseAndComplication.put("?????????", "complication");
    }

    private void initRelationsBetweenDiseaseAndPathophysiology() {
        relationsBetweenDiseaseAndPathophysiology.put("?????????", "complication");
    }

    private void initRelationsBetweenDiseaseAndDiseaseSite() {
        relationsBetweenDiseaseAndDiseaseSite.put("????????????", "diseaseSite");
    }

    private void initRelationsBetweenDiseaseAndDepartment() {
        relationsBetweenDiseaseAndDepartment.put("??????", "department");
    }

    private void initRelationsBetweenDiseaseAndMultipleGroups() {
        relationsBetweenDiseaseAndMultipleGroups.put("????????????", "multipleGroups");
    }

    private void initRelationsBetweenDiseaseAndPrognosticSurvivalTime() {
        relationsBetweenDiseaseAndPrognosticSurvivalTime.put("??????????????????", "prognosticSurvivalTime");
    }

    private void initRelationsBetweenDiseaseAndHighRiskFactors() {
        relationsBetweenDiseaseAndHighRiskFactors.put("????????????", "highRiskFactors");
    }

    private void initRelationsBetweenDiseaseAndRelatedDisease() {
        relationsBetweenDiseaseAndRelatedDisease.put("????????????", "relatedDisease");
    }

    private void initRelationsBetweenDiseaseAndRelatedSymptom() {
        relationsBetweenDiseaseAndRelatedSymptom.put("????????????", "relatedSymptom");
    }

    private void initRelationsBetweenDiseaseAndAdjuvantTherapy() {
        relationsBetweenDiseaseAndAdjuvantTherapy.put("????????????", "treatmentPrograms");
        relationsBetweenDiseaseAndAdjuvantTherapy.put("????????????", "adjuvantTherapy");

    }

    private void initRelationsBetweenDiseaseAndDrugTherapy() {
        relationsBetweenDiseaseAndDrugTherapy.put("????????????", "treatmentPrograms");
        relationsBetweenDiseaseAndDrugTherapy.put("?????????", "diseaseRate");
    }

    private void initRelationsBetweenDiseaseAndOperation() {
        relationsBetweenDiseaseAndOperation.put("????????????", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndTreatment() {
        relationsBetweenDiseaseAndTreatment.put("????????????", "treatmentPrograms");
        relationsBetweenDiseaseAndTreatment.put("????????????", "adjuvantTherapy");
    }

    private void initRelationsBetweenDiseaseAndCheck() {
        relationsBetweenDiseaseAndCheck.put("????????????", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndAuxiliaryExamination() {
        relationsBetweenDiseaseAndAuxiliaryExamination.put("????????????", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndTreatmentPrograms() {
        relationsBetweenDiseaseAndTreatmentPrograms.put("????????????", "treatmentPrograms");
    }

    private void initRelationsBetweenDiseaseAndSymptomAndSign() {
        relationsBetweenDiseaseAndSymptomAndSign.put("?????????????????????", "symptomAndSign");
    }

    private void initRelationsBetweenDiseaseAndPrognosis() {
        relationsBetweenDiseaseAndPrognosis.put("??????????????????", "prognosis");
    }

    private void initRelationsBetweenDiseaseAndAttribute() {
        relationsBetweenDiseaseAndAttribute.put("?????????", "diseaseRate");
    }

    private void initRelationsBetweenDiseaseAndDrug() {
        relationsBetweenDiseaseAndDrug.put("????????????", "drugTherapy");
    }

    private void initRelationsBetweenDiseaseAndPathogenesis() {
        relationsBetweenDiseaseAndPathogenesis.put("????????????", "pathogenesis");
    }

    private void initRelationsBetweenDiseaseAndPathologicalType() {
        relationsBetweenDiseaseAndPathologicalType.put("????????????", "pathologicalType");
    }

    private void initRelationsBetweenDiseaseAndDiagnosis() {
        relationsBetweenDiseaseAndDiagnosis.put("????????????", "diagnosis");
    }

}
