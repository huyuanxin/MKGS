package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.mapper.neo4j.*;
import org.graduation.knowledge.model.Relation;
import org.graduation.knowledge.model.dto.ImportDataDTO;
import org.graduation.knowledge.service.ImportRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author huyuanxin
 */
@Service("ImportRelationService")
public class ImportRelationServiceImpl implements ImportRelationService {

    //疾病

    final Disease3dMapper disease3dMapper;

    //并发症

    final Complication3dMapper complication3dMapper;
    final Symptom3dMapper symptom3dMapper;

    final PathologicalType3dMapper pathologicalType3dMapper;
    final Treatment3dMapper treatment3dMapper;
    final Diagnosis3dMapper diagnosis3dMapper;
    final Pathophysiology3dMapper pathophysiology3dMapper;
    final DiseaseSite3dMapper diseaseSite3dMapper;
    final Department3dMapper department3dMapper;
    final MultipleGroups3dMapper multipleGroups3dMapper;
    final Cause3dMapper cause3dMapper;
    final PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper;
    final HighRiskFactors3dMapper highRiskFactors3dMapper;
    final Drug3dMapper drug3dMapper;
    final Prognosis3dMapper prognosis3dMapper;
    final Attribute3dMapper attribute3dMapper;
    final DiseaseRate3dMapper diseaseRate3dMapper;
    final DrugTherapy3dMapper drugTherapy3dMapper;
    final AdjuvantTherapy3dMapper adjuvantTherapy3dMapper;
    final Operation3dMapper operation3dMapper;
    final Pathogenesis3dMapper pathogenesis3dMapper;
    final SymptomAndSign3dMapper symptomAndSign3dMapper;


    //症状

    final Check3dMapper check3dMapper;
    final RelatedDisease3dMapper relatedDisease3dMapper;
    final RelatedSymptom3dMapper relatedSymptom3dMapper;
    final Infectious3dMapper infectious3dMapper;
    final RelatedTo3dMapper relatedTo3dMapper;
    final AuxiliaryExamination3dMapper auxiliaryExamination3dMapper;
    final Stage3dMapper stage3dMapper;
    final TreatmentPrograms3dMapper treatmentPrograms3dMapper;
    final Prevention3dMapper prevention3dMapper;
    final SpreadWay3dMapper spreadWay3dMapper;

    //药物

    final Type3dMapper type3dMapper;
    final Precautions3dMapper precautions3dMapper;
    final Contraindications3dMapper contraindications3dMapper;
    final Subject3dMapper subject3dMapper;
    final Ingredients3dMapper ingredients3dMapper;
    final OTC3dMapper otc3dMapper;
    final AdverseReactions3dMapper adverseReactions3dMapper;
    final Indications3dMapper indications3dMapper;

    //诊疗

    final CheckSubject3dMapper checkSubject3dMapper;

    final DiseaseRelation3dMapper diseaseRelation3dMapper;
    final SymptomRelation3dMapper symptomRelation3dMapper;
    final DrugRelation3dMapper drugRelation3dMapper;
    final TreatmentRelation3dMapper treatmentRelation3dMapper;

    @Autowired
    public ImportRelationServiceImpl(Disease3dMapper disease3dMapper, Symptom3dMapper symptom3dMapper, Complication3dMapper complication3dMapper, PathologicalType3dMapper pathologicalType3dMapper, Treatment3dMapper treatment3dMapper, Diagnosis3dMapper diagnosis3dMapper, Pathophysiology3dMapper pathophysiology3dMapper, DiseaseSite3dMapper diseaseSite3dMapper, Department3dMapper department3dMapper, MultipleGroups3dMapper multipleGroups3dMapper, Cause3dMapper cause3dMapper, PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper, HighRiskFactors3dMapper highRiskFactors3dMapper, Prognosis3dMapper prognosis3dMapper, Attribute3dMapper attribute3dMapper, DiseaseRate3dMapper diseaseRate3dMapper, Drug3dMapper drug3dMapper, DrugTherapy3dMapper drugTherapy3dMapper, AdjuvantTherapy3dMapper adjuvantTherapy3dMapper, Operation3dMapper operation3dMapper, Pathogenesis3dMapper pathogenesis3dMapper, Check3dMapper check3dMapper, RelatedDisease3dMapper relatedDisease3dMapper, RelatedSymptom3dMapper relatedSymptom3dMapper, Infectious3dMapper infectious3dMapper, RelatedTo3dMapper relatedTo3dMapper, SymptomAndSign3dMapper symptomAndSign3dMapper, AuxiliaryExamination3dMapper auxiliaryExamination3dMapper, Stage3dMapper stage3dMapper, TreatmentPrograms3dMapper treatmentPrograms3dMapper, Prevention3dMapper prevention3dMapper, SpreadWay3dMapper spreadWay3dMapper, Type3dMapper type3dMapper, Precautions3dMapper precautions3dMapper, Contraindications3dMapper contraindications3dMapper, Subject3dMapper subject3dMapper, Ingredients3dMapper ingredients3dMapper, OTC3dMapper otc3dMapper, AdverseReactions3dMapper adverseReactions3dMapper, Indications3dMapper indications3dMapper, CheckSubject3dMapper checkSubject3dMapper, DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper, DrugRelation3dMapper drugRelation3dMapper, TreatmentRelation3dMapper treatmentRelation3dMapper) {
        //疾病
        this.disease3dMapper = disease3dMapper;
        this.complication3dMapper = complication3dMapper;
        this.symptom3dMapper = symptom3dMapper;
        this.pathologicalType3dMapper = pathologicalType3dMapper;
        this.treatment3dMapper = treatment3dMapper;
        this.diagnosis3dMapper = diagnosis3dMapper;
        this.pathophysiology3dMapper = pathophysiology3dMapper;
        this.diseaseSite3dMapper = diseaseSite3dMapper;
        this.department3dMapper = department3dMapper;
        this.multipleGroups3dMapper = multipleGroups3dMapper;
        this.cause3dMapper = cause3dMapper;
        this.prognosticSurvivalTime3dMapper = prognosticSurvivalTime3dMapper;
        this.highRiskFactors3dMapper = highRiskFactors3dMapper;
        this.prognosis3dMapper = prognosis3dMapper;
        this.attribute3dMapper = attribute3dMapper;
        this.diseaseRate3dMapper = diseaseRate3dMapper;
        this.drug3dMapper = drug3dMapper;
        this.drugTherapy3dMapper = drugTherapy3dMapper;
        this.adjuvantTherapy3dMapper = adjuvantTherapy3dMapper;
        this.operation3dMapper = operation3dMapper;
        this.pathogenesis3dMapper = pathogenesis3dMapper;

        //症状
        this.check3dMapper = check3dMapper;
        this.relatedDisease3dMapper = relatedDisease3dMapper;
        this.relatedSymptom3dMapper = relatedSymptom3dMapper;
        this.infectious3dMapper = infectious3dMapper;
        this.relatedTo3dMapper = relatedTo3dMapper;
        this.symptomAndSign3dMapper = symptomAndSign3dMapper;
        this.auxiliaryExamination3dMapper = auxiliaryExamination3dMapper;
        this.stage3dMapper = stage3dMapper;
        this.treatmentPrograms3dMapper = treatmentPrograms3dMapper;
        this.prevention3dMapper = prevention3dMapper;
        this.spreadWay3dMapper = spreadWay3dMapper;

        //药物
        this.type3dMapper = type3dMapper;
        this.precautions3dMapper = precautions3dMapper;
        this.contraindications3dMapper = contraindications3dMapper;
        this.subject3dMapper = subject3dMapper;
        this.ingredients3dMapper = ingredients3dMapper;
        this.otc3dMapper = otc3dMapper;
        this.adverseReactions3dMapper = adverseReactions3dMapper;
        this.indications3dMapper = indications3dMapper;

        //诊疗
        this.checkSubject3dMapper = checkSubject3dMapper;

        this.diseaseRelation3dMapper = diseaseRelation3dMapper;
        this.symptomRelation3dMapper = symptomRelation3dMapper;
        this.drugRelation3dMapper = drugRelation3dMapper;
        this.treatmentRelation3dMapper = treatmentRelation3dMapper;
    }

    /**
     * 插入关系
     *
     * @param importDataDTO 前端的保存的结果
     */
    @Override
    public void insertRelations(ImportDataDTO importDataDTO, HashMap<String, String> entities) {
        importDataDTO.getRelations().forEach(it -> insertRelationsHandler(it, entities));
    }

    @SuppressWarnings({"AlibabaMethodTooLong", "AlibabaUndefineMagicConstant"})
    private void insertRelationsHandler(Relation relation, HashMap<String, String> entities) {
        String[] split = relation.getKey().split("-ignore")[0].split("&&");
        String headName = split[0];
        String tailName = split[1];
        String headType = entities.get(headName);
        String tailType = entities.get(tailName);
        switch (relation.getRelationName()) {
            case "diseaseSite": {
                diseaseSiteHandler(headName, tailName, headType, tailType);
                break;
            }
            case "department": {
                departmentHandler(headName, tailName, headType, tailType);
                break;
            }
            case "multipleGroups": {
                multipleGroupsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "cause": {
                causeHandler(headName, tailName, headType, tailType);
                break;
            }
            case "prognosticSurvivalTime": {
                prognosticSurvivalTimeHandler(headName, tailName, headType, tailType);
                break;
            }
            case "highRiskFactors": {
                highRiskFactorsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "relatedDisease": {
                relatedDiseaseHandler(headName, tailName, headType, tailType);
                break;
            }
            case "relatedSymptom": {
                relatedSymptomHandler(headName, tailName, headType, tailType);
                break;
            }
            case "treatmentPrograms": {
                treatmentProgramsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "symptomAndSign": {
                symptomAndSignHandler(headName, tailName, headType, tailType);
                break;
            }
            case "prognosis": {
                prognosisHandler(headName, tailName, headType, tailType);
                break;
            }
            case "diseaseRate": {
                diseaseRateHandler(headName, tailName, headType, tailType);
                break;
            }
            case "drugTherapy": {
                drugTherapyHandler(headName, tailName, headType, tailType);
                break;
            }
            case "adjuvantTherapy": {
                adjuvantTherapyHandler(headName, tailName, headType, tailType);
                break;
            }
            case "pathogenesis": {
                pathogenesisHandler(headName, tailName, headType, tailType);
                break;
            }
            case "operation": {
                operationHandler(headName, tailName, headType, tailType);
                break;
            }
            case "pathologicalType": {
                pathologicalTypeHandler(headName, tailName, headType, tailType);
                break;
            }
            case "diagnosis": {
                diagnosisHandler(headName, tailName, headType, tailType);
                break;
            }
            case "spreadWay": {
                spreadWayHandler(headName, tailName, headType, tailType);
                break;
            }
            case "prevention": {
                preventionHandler(headName, tailName, headType, tailType);
                break;
            }
            case "ingredients": {
                ingredientsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "OTC": {
                otcHandler(headName, tailName, headType, tailType);
                break;
            }
            case "adverseReactions": {
                adverseReactionsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "indications": {
                indicationsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "type": {
                typeHandler(headName, tailName, headType, tailType);
                break;
            }
            case "precautions": {
                precautionsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "contraindications": {
                contraindicationsHandler(headName, tailName, headType, tailType);
                break;
            }
            case "subject": {
                subjectHandler(headName, tailName, headType, tailType);
                break;
            }
            case "checkSubject": {
                checkSubjectHandler(headName, tailName, headType, tailType);
                break;
            }
            case "check": {
                checkHandler(headName, tailName, headType, tailType);
                break;
            }
            case "infectious": {
                infectiousHandler(headName, tailName, headType, tailType);
                break;
            }
            case "complication": {
                complicationHandler(headName, tailName, headType, tailType);
                break;
            }
            case "relatedTo": {
                relatedToHandler(headName, tailName, headType, tailType);
                break;
            }
            case "relAuxiliaryExamination": {
                relAuxiliaryExaminationHandler(headName, tailName, headType, tailType);
                break;
            }
            case "stage": {
                stageHandler(headName, tailName, headType, tailType);
                break;
            }
            default: {
                break;
            }
        }
    }

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void diseaseSiteHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "diseaseSite".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseSiteDTP(headName, tailName);
        } else if ("disease".equals(headType) && "disease".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseSiteDTD(headName, tailName);
        } else if ("disease".equals(headType) && "symptom".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseSiteDTS(headName, tailName);
        } else if ("symptom".equals(headType) && "diseaseSite".equals(tailType)) {
            symptomRelation3dMapper.insertRelDiseaseSiteSTDS(headName, tailName);
        } else if ("symptom".equals(headType) && "symptom".equals(tailType)) {
            symptomRelation3dMapper.insertRelDiseaseSiteSTS(headName, tailName);
        } else if ("symptom".equals(headType) && "disease".equals(tailType)) {
            symptomRelation3dMapper.insertRelDiseaseSiteSTD(headName, tailName);
        }
    }

    //关系：疾病-所属科室

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void departmentHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "department".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDepartmentDTD(headName, tailName);
        } else if ("symptom".equals(headType) && "department".equals(tailType)) {
            symptomRelation3dMapper.insertRelDepartment(headName, tailName);
        }
    }

    //关系：疾病-多发群体

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void multipleGroupsHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "multipleGroups".equals(tailType)) {
            diseaseRelation3dMapper.insertRelMultipleGroupsDTM(headName, tailName);
        } else if ("symptom".equals(headType) && "multipleGroups".equals(tailType)) {
            symptomRelation3dMapper.insertRelMultipleGroups(headName, tailName);
        }
    }

    //关系：疾病-病因

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void causeHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "cause".equals(tailType)) {
            diseaseRelation3dMapper.insertRelCauseDTC(headName, tailName);
        } else if ("disease".equals(headType) && "disease".equals(tailType)) {
            diseaseRelation3dMapper.insertRelCauseDTD(headName, tailName);
        } else if ("symptom".equals(headType) && "cause".equals(tailType)) {
            symptomRelation3dMapper.insertRelCauseSTC(headName, tailName);
        } else if ("symptom".equals(headType) && "disease".equals(tailType)) {
            symptomRelation3dMapper.insertRelCauseSTD(headName, tailName);
        }
    }

    //关系：疾病-预后生存时间

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void prognosticSurvivalTimeHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "prognosticSurvivalTime".equals(tailType)) {
            diseaseRelation3dMapper.insertRelPrognosticSurvivalTimeDTP(headName, tailName);
        }
    }

    //关系：疾病-高危因素

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void highRiskFactorsHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "highRiskFactors".equals(tailType)) {
            diseaseRelation3dMapper.insertRelHighRiskFactorsDTH(headName, tailName);
        }
    }

    //关系：疾病-相关疾病

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void relatedDiseaseHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "relatedDisease".equals(tailType)) {
            diseaseRelation3dMapper.insertRelRelatedDiseaseDTR(headName, tailName);
        } else if ("disease".equals(headType) && "disease".equals(tailType)) {
            diseaseRelation3dMapper.insertRelRelatedDiseaseDTD(headName, tailName);
        } else if ("treatment".equals(headType) && "relatedDisease".equals(tailType)) {
            treatmentRelation3dMapper.insertRelRelatedDiseaseTTR(headName, tailName);
        } else if ("treatment".equals(headType) && "disease".equals(tailType)) {
            treatmentRelation3dMapper.insertRelRelatedDiseaseTTD(headName, tailName);
        } else if ("symptom".equals(headType) && "relatedDisease".equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedDiseaseSTR(headName, tailName);
        } else if ("symptom".equals(headType) && "disease".equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedDiseaseSTD(headName, tailName);
        }
    }

    //关系：疾病-相关症状

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void relatedSymptomHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "relatedSymptom".equals(tailType)) {
            diseaseRelation3dMapper.insertRelRelatedSymptomDTR(headName, tailName);
        } else if ("disease".equals(headType) && "symptom".equals(tailType)) {
            diseaseRelation3dMapper.insertRelRelatedSymptomDTS(headName, tailName);
        } else if ("treatment".equals(headType) && "relatedSymptom".equals(tailType)) {
            treatmentRelation3dMapper.insertRelRelatedSymptomTTR(headName, tailName);
        } else if ("treatment".equals(headType) && "symptom".equals(tailType)) {
            treatmentRelation3dMapper.insertRelRelatedDiseaseTTS(headName, tailName);
        } else if ("symptom".equals(headType) && "relatedSymptom".equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedSymptomSTR(headName, tailName);
        } else if ("symptom".equals(headType) && "symptom".equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedSymptomSTS(headName, tailName);
        }
    }

    // 关系:疾病-治疗方案

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void treatmentProgramsHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "treatmentPrograms".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTTP(headName, tailName);
        } else if ("disease".equals(headType) && "adjuvantTherapy".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTA(headName, tailName);
        } else if ("disease".equals(headType) && "drugTherapy".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTU(headName, tailName);
        } else if ("disease".equals(headType) && "operation".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTO(headName, tailName);
        } else if ("disease".equals(headType) && "drug".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTD(headName, tailName);
        } else if ("disease".equals(headType) && "treatment".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTT(headName, tailName);
        } else if ("disease".equals(headType) && "check".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTC(headName, tailName);
        } else if ("disease".equals(headType) && "auxiliaryExamination".equals(tailType)) {
            diseaseRelation3dMapper.insertRelTreatmentProgramsDTE(headName, tailName);
        } else if ("symptom".equals(headType) && "adjuvantTherapy".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTA(headName, tailName);
        } else if ("symptom".equals(headType) && "drugTherapy".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTU(headName, tailName);
        } else if ("symptom".equals(headType) && "operation".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTO(headName, tailName);
        } else if ("symptom".equals(headType) && "drug".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTD(headName, tailName);
        } else if ("symptom".equals(headType) && "treatment".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTT(headName, tailName);
        } else if ("symptom".equals(headType) && "check".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTC(headName, tailName);
        } else if ("symptom".equals(headType) && "auxiliaryExamination".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTE(headName, tailName);
        } else if ("symptom".equals(headType) && "treatmentPrograms".equals(tailType)) {
            symptomRelation3dMapper.insertRelTreatmentProgramsSTTP(headName, tailName);
        }
    }

    // 插入临床症状及体征关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void symptomAndSignHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "symptomAndSign".equals(tailType)) {
            diseaseRelation3dMapper.insertRelSymptomAndSignDTSAS(headName, tailName);
        } else if ("disease".equals(headType) && "disease".equals(tailType)) {
            diseaseRelation3dMapper.insertRelSymptomAndSignDTD(headName, tailName);
        } else if ("disease".equals(headType) && "symptom".equals(tailType)) {
            diseaseRelation3dMapper.insertRelSymptomAndSignDTS(headName, tailName);
        } else if ("symptom".equals(headType) && "symptomAndSign".equals(tailType)) {
            symptomRelation3dMapper.insertRelSymptomAndSignSTSAS(headName, tailName);
        } else if ("symptom".equals(headType) && "disease".equals(tailType)) {
            symptomRelation3dMapper.insertRelSymptomAndSignSTD(headName, tailName);
        } else if ("symptom".equals(headType) && "symptom".equals(tailType)) {
            symptomRelation3dMapper.insertRelSymptomAndSignSTS(headName, tailName);
        }
    }

    // 插入预后状况关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void prognosisHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "prognosis".equals(tailType)) {
            diseaseRelation3dMapper.insertRelPrognosis(headName, tailName);
        }
    }

    // 插入发病率关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void diseaseRateHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "diseaseRate".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseRateDTDR(headName, tailName);
        } else if ("disease".equals(headType) && "attribute".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseRateDTA(headName, tailName);
        }
    }

    // 插入药物治疗关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void drugTherapyHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "drugTherapy".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDrugTherapyDTDT(headName, tailName);
        } else if ("disease".equals(headType) && "drug".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDrugTherapyDTD(headName, tailName);
        } else if ("symptom".equals(headType) && "drugTherapy".equals(tailType)) {
            symptomRelation3dMapper.insertRelDrugTherapySTDT(headName, tailName);
        } else if ("symptom".equals(headType) && "drug".equals(tailType)) {
            symptomRelation3dMapper.insertRelDrugTherapySTD(headName, tailName);
        }
    }

    // 插入临辅助治疗关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void adjuvantTherapyHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "adjuvantTherapy".equals(tailType)) {
            diseaseRelation3dMapper.insertRelAdjuvantTherapyDTA(headName, tailName);
        } else if ("disease".equals(headType) && "treatment".equals(tailType)) {
            diseaseRelation3dMapper.insertRelAdjuvantTherapyDTT(headName, tailName);
        } else if ("symptom".equals(headType) && "adjuvantTherapy".equals(tailType)) {
            symptomRelation3dMapper.insertRelAdjuvantTherapySTA(headName, tailName);
        } else if ("symptom".equals(headType) && "treatment".equals(tailType)) {
            symptomRelation3dMapper.insertRelAdjuvantTherapySTT(headName, tailName);
        }
    }

    //  插入手术治疗关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void operationHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "operation".equals(tailType)) {
            diseaseRelation3dMapper.insertRelOperationDTO(headName, tailName);
        } else if ("disease".equals(headType) && "treatment".equals(tailType)) {
            diseaseRelation3dMapper.insertRelOperationDTT(headName, tailName);
        }
    }

    // 插入发病机制关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void pathogenesisHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "pathogenesis".equals(tailType)) {
            diseaseRelation3dMapper.insertRelPathogenesisDTO(headName, tailName);
        }
    }

    // 插入病理分型关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void pathologicalTypeHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "pathologicalType".equals(tailType)) {
            diseaseRelation3dMapper.insertRelPathologicalTypeDTO(headName, tailName);
        } else if ("symptom".equals(headType) && "pathologicalType".equals(tailType)) {
            symptomRelation3dMapper.insertRelPathologicalType(headName, tailName);
        }
    }

    // 插入鉴别诊断关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void diagnosisHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "diagnosis".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiagnosisDTT(headName, tailName);
        } else if ("disease".equals(headType) && "treatment".equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiagnosisDTDI(headName, tailName);
        }
    }

    // 关系：症状-预防

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void preventionHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "prevention".equals(tailType)) {
            symptomRelation3dMapper.insertRelPreventionSTP(headName, tailName);
        }
    }

    // 关系：症状-传播途径

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void spreadWayHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "spreadWay".equals(tailType)) {
            symptomRelation3dMapper.insertRelSpreadWaySTSW(headName, tailName);
        }
    }

    // 关系：药物-成份

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void ingredientsHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "ingredients".equals(tailType)) {
            drugRelation3dMapper.insertRelIngredientsDTI(headName, tailName);
        }
    }

    // 关系：药物-OTC类型

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void otcHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "OTC".equals(tailType)) {
            drugRelation3dMapper.insertRelOTCDTO(headName, tailName);
        }
    }

    // 关系：药物-不良反应

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void adverseReactionsHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "adverseReactions".equals(tailType)) {
            drugRelation3dMapper.insertRelAdverseReactionsDTA(headName, tailName);
        } else if ("drug".equals(headType) && "disease".equals(tailType)) {
            drugRelation3dMapper.insertRelAdverseReactionsDTD(headName, tailName);
        } else if ("drug".equals(headType) && "symptom".equals(tailType)) {
            drugRelation3dMapper.insertRelAdverseReactionsDTS(headName, tailName);
        } else if ("drug".equals(headType) && "complication".equals(tailType)) {
            drugRelation3dMapper.insertRelAdverseReactionsDTE(headName, tailName);
        }
    }

    // 关系：药物-适应症

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void indicationsHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "indications".equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTI(headName, tailName);
        } else if ("drug".equals(headType) && "disease".equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTD(headName, tailName);
        } else if ("drug".equals(headType) && "symptom".equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTS(headName, tailName);
        } else if ("drug".equals(headType) && "complication".equals(tailType)) {
            drugRelation3dMapper.insertRelIndicationsDTE(headName, tailName);
        }
    }

    // 关系：药物-分类

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void typeHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "type".equals(tailType)) {
            drugRelation3dMapper.insertRelTypeDTT(headName, tailName);
        }
    }

    /**
     * 关系：药物-注意事项/
     **/
    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void precautionsHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "precautions".equals(tailType)) {
            drugRelation3dMapper.insertRelPrecautionsDTP(headName, tailName);
        }
    }


    // 关系：药物-注意事项/

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void contraindicationsHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "contraindications".equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTC(headName, tailName);
        } else if ("drug".equals(headType) && "disease".equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTD(headName, tailName);
        } else if ("drug".equals(headType) && "symptom".equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTS(headName, tailName);
        } else if ("drug".equals(headType) && "complication".equals(tailType)) {
            drugRelation3dMapper.insertRelContraindicationsDTE(headName, tailName);
        }
    }

    // 关系：药物-所属科目

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void subjectHandler(String headName, String tailName, String headType, String tailType) {
        if ("drug".equals(headType) && "subject".equals(tailType)) {
            drugRelation3dMapper.insertRelSubjectDTS(headName, tailName);
        }
    }

    // 关系：诊疗-检查科目

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void checkSubjectHandler(String headName, String tailName, String headType, String tailType) {
        if ("treatment".equals(headType) && "checkSubject".equals(tailType)) {
            treatmentRelation3dMapper.insertRelCheckSubjectTTCS(headName, tailName);
        } else if ("treatment".equals(headType) && "check".equals(tailType)) {
            treatmentRelation3dMapper.insertRelCheckSubjectTTC(headName, tailName);
        }
    }

    // 插入检查关系/

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void checkHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "check".equals(tailType)) {
            symptomRelation3dMapper.insertRelCheckSTC(headName, tailName);
        } else if ("symptom".equals(headType) && "auxiliaryExamination".equals(tailType)) {
            symptomRelation3dMapper.insertRelCheckSTA(headName, tailName);
        } else if ("symptom".equals(headType) && "checkSubject".equals(tailType)) {
            symptomRelation3dMapper.insertRelCheckSTCS(headName, tailName);
        }
    }

    // 插入传染性关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void infectiousHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "infectious".equals(tailType)) {
            symptomRelation3dMapper.insertRelInfectious(headName, tailName);
        }
    }

    // 关系：疾病-并发症

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void complicationHandler(String headName, String tailName, String headType, String tailType) {
        if ("disease".equals(headType) && "complication".equals(tailType)) {
            diseaseRelation3dMapper.insertRelComplicationDTC(headName, tailName);
        } else if ("disease".equals(headType) && "disease".equals(tailType)) {
            diseaseRelation3dMapper.insertRelComplicationDTD(headName, tailName);
        } else if ("disease".equals(headType) && "symptom".equals(tailType)) {
            diseaseRelation3dMapper.insertRelComplicationDTS(headName, tailName);
        } else if ("symptom".equals(headType) && "disease".equals(tailType)) {
            symptomRelation3dMapper.insertRelComplicationSTD(headName, tailName);
        } else if ("symptom".equals(headType) && "symptom".equals(tailType)) {
            symptomRelation3dMapper.insertRelComplicationSTS(headName, tailName);
        } else if ("symptom".equals(headType) && "complication".equals(tailType)) {
            symptomRelation3dMapper.insertRelComplicationSTC(headName, tailName);
        }
    }

    // 插入相关导致关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void relatedToHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "relatedTo".equals(tailType)) {
            symptomRelation3dMapper.insertRelRelatedTo(headName, tailName);
        }
    }

    // 插入辅助检查关系/

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void relAuxiliaryExaminationHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "check".equals(tailType)) {
            symptomRelation3dMapper.insertRelAuxiliaryExaminationSTC(headName, tailName);
        } else if ("symptom".equals(headType) && "auxiliaryExamination".equals(tailType)) {
            symptomRelation3dMapper.insertRelAuxiliaryExaminationSTA(headName, tailName);
        } else if ("symptom".equals(headType) && "checkSubject".equals(tailType)) {
            symptomRelation3dMapper.insertRelAuxiliaryExaminationSTCS(headName, tailName);
        }
    }

    // 插入阶段关系

    @SuppressWarnings({"AlibabaUndefineMagicConstant"})
    void stageHandler(String headName, String tailName, String headType, String tailType) {
        if ("symptom".equals(headType) && "stage".equals(tailType)) {
            symptomRelation3dMapper.insertRelStage(headName, tailName);
        }
    }

}
