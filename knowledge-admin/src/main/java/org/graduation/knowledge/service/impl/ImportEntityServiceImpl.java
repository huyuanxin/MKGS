package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.mapper.neo4j.*;
import org.graduation.knowledge.service.ImportEntityService;
import org.graduation.knowledge.util.RelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author huyuanxin
 */
@Service("ImportEntityService")
public class ImportEntityServiceImpl implements ImportEntityService {
    // 疾病

    final Disease3dMapper disease3dMapper;
    // 并发症

    final Complication3dMapper complication3dMapper;
    final Symptom3dMapper symptom3dMapper;

    final PathologicalType3dMapper pathologicalType3dMapper;
    final Treatment3dMapper treatment3DMapper;
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

    @Autowired
    public ImportEntityServiceImpl(Disease3dMapper disease3dMapper, Symptom3dMapper symptom3dMapper, Complication3dMapper complication3dMapper, PathologicalType3dMapper pathologicalType3dMapper, Treatment3dMapper treatment3dMapper, Diagnosis3dMapper diagnosis3dMapper, Pathophysiology3dMapper pathophysiology3dMapper, DiseaseSite3dMapper diseaseSite3dMapper, Department3dMapper department3dMapper, MultipleGroups3dMapper multipleGroups3dMapper, Cause3dMapper cause3dMapper, PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper, HighRiskFactors3dMapper highRiskFactors3dMapper, Prognosis3dMapper prognosis3dMapper, Attribute3dMapper attribute3dMapper, DiseaseRate3dMapper diseaseRate3dMapper, Drug3dMapper drug3dMapper, DrugTherapy3dMapper drugTherapy3dMapper, AdjuvantTherapy3dMapper adjuvantTherapy3dMapper, Operation3dMapper operation3dMapper, Pathogenesis3dMapper pathogenesis3dMapper, Check3dMapper check3dMapper, RelatedDisease3dMapper relatedDisease3dMapper, RelatedSymptom3dMapper relatedSymptom3dMapper, Infectious3dMapper infectious3dMapper, RelatedTo3dMapper relatedTo3dMapper, SymptomAndSign3dMapper symptomAndSign3dMapper, AuxiliaryExamination3dMapper auxiliaryExamination3dMapper, Stage3dMapper stage3dMapper, TreatmentPrograms3dMapper treatmentPrograms3dMapper, Prevention3dMapper prevention3dMapper, SpreadWay3dMapper spreadWay3dMapper, Type3dMapper type3dMapper, Precautions3dMapper precautions3dMapper, Contraindications3dMapper contraindications3dMapper, Subject3dMapper subject3dMapper, Ingredients3dMapper ingredients3dMapper, OTC3dMapper otc3dMapper, AdverseReactions3dMapper adverseReactions3dMapper, Indications3dMapper indications3dMapper, CheckSubject3dMapper checkSubject3dMapper) {
        //疾病
        this.disease3dMapper = disease3dMapper;
        this.complication3dMapper = complication3dMapper;
        this.symptom3dMapper = symptom3dMapper;
        this.pathologicalType3dMapper = pathologicalType3dMapper;
        this.treatment3DMapper = treatment3dMapper;
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
    }

    /**
     * 保存实体
     *
     * @param entities 前端的保存的结果中的entities
     */
    @Override
    public void importEntity(HashMap<String, String> entities) {
        entities.replaceAll((k, v) -> importEntityHandler(k, RelationUtil.getInstance().mappingEntityMap(entities.get(k))));
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    private String importEntityHandler(String entityName, String entityType) {
        // 处理
        switch (entityType) {
            case "disease": {
                return insertDisease(entityName);
            }
            case "symptom": {
                return insertSymptom(entityName);
            }
            case "complication": {
                return insertComplication(entityName);
            }
            case "pathologicalType": {
                return insertPathologicalType(entityName);
            }
            case "treatment": {
                return insertTreatment(entityName);
            }
            case "diagnosis": {
                return insertDiagnosis(entityName);
            }
            case "pathophysiology": {
                return insertPathophysiology(entityName);
            }
            case "diseaseSite": {
                return insertDiseaseSite(entityName);
            }
            case "department": {
                return insertDepartment(entityName);
            }
            case "multipleGroups": {
                return insertMultipleGroups(entityName);
            }
            case "cause": {
                return insertCause(entityName);
            }
            case "prognosticSurvivalTime": {
                return insertPrognosticSurvivalTime(entityName);
            }
            case "highRiskFactors": {
                return insertHighRiskFactors(entityName);
            }
            case "prognosis": {
                return insertPrognosis(entityName);
            }
            case "attribute": {
                return insertAttribute(entityName);
            }
            case "diseaseRate": {
                return insertDiseaseRate(entityName);
            }
            case "drug": {
                return insertDrug(entityName);
            }
            case "operation": {
                return insertOperation(entityName);
            }
            case "pathogenesis": {
                return insertPathogenesis(entityName);
            }
            case "treatmentPrograms": {
                return insertTreatmentPrograms(entityName);

            }
            case "relatedSymptom": {
                return insertRelatedSymptom(entityName);
            }
            case "check": {
                return insertCheck(entityName);

            }
            case "relatedDisease": {
                return insertRelatedDisease(entityName);

            }
            case "adjuvantTherapy": {
                return insertAdjuvantTherapy(entityName);

            }
            case "infectious": {
                return insertInfectious(entityName);
            }
            case "relatedTo": {
                return insertRelatedTo(entityName);
            }
            case "symptomAndSign": {
                return insertSymptomAndSign(entityName);
            }
            case "auxiliaryExamination": {
                return insertAuxiliaryExamination(entityName);
            }
            case "drugTherapy": {
                return insertDrugTherapy(entityName);
            }
            case "stage": {
                return insertStage(entityName);
            }
            case "prevention": {
                return insertPrevention(entityName);
            }
            case "spreadWay": {
                return insertSpreadWay(entityName);
            }
            case "type": {
                return insertType(entityName);
            }
            case "precautions": {
                return insertPrecautions(entityName);
            }
            case "contraindications": {
                return insertContraindications(entityName);
            }
            case "subject": {
                return insertSubject(entityName);
            }
            case "ingredients": {
                return insertIngredients(entityName);
            }
            case "OTC": {
                return insertOtc(entityName);
            }
            case "adverseReactions": {
                return insertAdverseReactions(entityName);
            }
            case "indications": {
                return insertIndications(entityName);
            }
            case "checkSubject": {
                return insertCheckSubject(entityName);
            }
            default: {
                break;
            }
        }
        return "";
    }

    private String insertDisease(String entityName) {
        if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else {
            disease3dMapper.insertDisease(entityName);
        }
        return "disease";
    }

    private String insertSymptom(String entityName) {
        if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else {
            symptom3dMapper.insertSymptom(entityName);
        }
        return "symptom";
    }

    private String insertComplication(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "complication";
        } else {
            complication3dMapper.insertComplication(entityName);
        }
        return "complication";
    }

    private String insertPathologicalType(String entityName) {
        if (pathologicalType3dMapper.isExits(entityName) < 1) {
            pathologicalType3dMapper.insertPathologicalType(entityName);
        }
        return "pathological";
    }

    private String insertTreatment(String entityName) {
        if (treatment3DMapper.isExits(entityName) < 1) {
            treatment3DMapper.insertTreatment(entityName);
        }
        return "treatment";
    }

    private String insertDiagnosis(String entityName) {
        if (treatment3DMapper.isExits(entityName) >= 1) {
            return "treatment";
        } else if (diagnosis3dMapper.isExits(entityName) >= 1) {
            return "diagnosis";
        } else {
            diagnosis3dMapper.insertDiagnosis(entityName);
        }
        return "diagnosis";
    }

    private String insertPathophysiology(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (pathophysiology3dMapper.isExits(entityName) >= 1) {
            return "pathophysiology";
        } else {
            pathophysiology3dMapper.insertPathophysiology(entityName);
        }
        return "pathophysiology";
    }

    private String insertDepartment(String entityName) {
        if (department3dMapper.isExits(entityName) < 1) {
            department3dMapper.insertDepartment(entityName);
        }
        return "department";
    }

    private String insertMultipleGroups(String entityName) {
        if (multipleGroups3dMapper.isExits(entityName) < 1) {
            multipleGroups3dMapper.insertMultipleGroups(entityName);
        }
        return "multipleGroups";
    }

    private String insertCause(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (cause3dMapper.isExits(entityName) >= 1) {
            return "cause";
        } else {
            cause3dMapper.insertCause(entityName);
        }
        return "cause";
    }

    private String insertPrognosticSurvivalTime(String entityName) {
        if (prognosticSurvivalTime3dMapper.isExits(entityName) < 1) {
            prognosticSurvivalTime3dMapper.insertPrognosticSurvivalTime(entityName);
        }
        return "prognosticSurvivalTime";
    }

    private String insertHighRiskFactors(String entityName) {
        if (prognosticSurvivalTime3dMapper.isExits(entityName) < 1) {
            highRiskFactors3dMapper.insertHighRiskFactors(entityName);
        }
        return "highRiskFactors3dMapper";
    }

    public String insertPrognosis(String entityName) {
        if (prognosis3dMapper.isExits(entityName) < 1) {
            prognosis3dMapper.insertPrognosis(entityName);
        }
        return "prognosis";
    }

    public String insertAttribute(String entityName) {
        if (attribute3dMapper.isExits(entityName) < 1) {
            attribute3dMapper.insertAttribute(entityName);
        }
        return "attribute";
    }

    public String insertDiseaseRate(String entityName) {
        if (attribute3dMapper.isExits(entityName) >= 1) {
            return "attribute";
        } else if (diseaseRate3dMapper.isExits(entityName) >= 1) {
            return "diseaseRate";
        } else {
            diseaseRate3dMapper.insertDiseaseRate(entityName);
        }
        return "diseaseRate";
    }

    public String insertDrug(String entityName) {
        if (drug3dMapper.isExits(entityName) < 1) {
            drug3dMapper.insertDrug(entityName);
        }
        return "drug";
    }

    public String insertOperation(String entityName) {
        if (treatment3DMapper.isExits(entityName) >= 1) {
            return "treatment";
        } else if (operation3dMapper.isExits(entityName) >= 1) {
            return "operation";
        } else {
            operation3dMapper.insertOperation(entityName);
        }
        return "operation";
    }

    private String insertPathogenesis(String entityName) {
        if (pathogenesis3dMapper.isExits(entityName) < 1) {
            pathogenesis3dMapper.insertPathogenesis(entityName);
        }
        return "pathogenesis";
    }

    private String insertTreatmentPrograms(String entityName) {
        if (adjuvantTherapy3dMapper.isExits(entityName) >= 1) {
            return "adjuvantTherapy";
        } else if (drugTherapy3dMapper.isExits(entityName) >= 1) {
            return "drugTherapy";
        } else if (drug3dMapper.isExits(entityName) >= 1) {
            return "drug";
        } else if (treatment3DMapper.isExits(entityName) >= 1) {
            return "treatment";
        } else if (check3dMapper.isExits(entityName) >= 1) {
            return "check";
        } else if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "auxiliaryExamination";
        } else if (operation3dMapper.isExits(entityName) >= 1) {
            return "operation";
        } else if (treatmentPrograms3dMapper.isExits(entityName) >= 1) {
            return "treatmentPrograms";
        } else {
            treatmentPrograms3dMapper.insertTreatmentPrograms(entityName);
        }
        return "treatmentPrograms";
    }

    private String insertRelatedSymptom(String entityName) {
        if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (relatedSymptom3dMapper.isExits(entityName) >= 1) {
            return "relatedSymptom";
        } else {
            relatedSymptom3dMapper.insertRelatedSymptom(entityName);
        }
        return "relatedSymptom";
    }

    //症状

    private String insertCheck(String entityName) {
        if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "auxiliaryExamination";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "checkSubject";
        } else if (check3dMapper.isExits(entityName) >= 1) {
            return "check";
        } else {
            check3dMapper.insertCheck(entityName);
        }
        return "check";
    }

    private String insertDiseaseSite(String entityName) {
        if (diseaseSite3dMapper.isExits(entityName) >= 1) {
            return "diseaseSite";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else {
            diseaseSite3dMapper.insertDiseaseSite(entityName);
        }
        return "diseaseSite";
    }

    private String insertRelatedDisease(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (relatedDisease3dMapper.isExits(entityName) >= 1) {
            return "relatedDisease";
        } else {
            relatedDisease3dMapper.insertRelatedDisease(entityName);
        }
        return "relatedDisease";
    }

    public String insertAdjuvantTherapy(String entityName) {
        if (adjuvantTherapy3dMapper.isExits(entityName) >= 1) {
            return "adjuvantTherapy";
        } else if (treatment3DMapper.isExits(entityName) >= 1) {
            return "treatment";
        } else {
            adjuvantTherapy3dMapper.insertAdjuvantTherapy(entityName);
        }
        return "treatment";
    }

    private String insertInfectious(String entityName) {
        if (infectious3dMapper.isExits(entityName) < 1) {
            infectious3dMapper.insertInfectious(entityName);
        }
        return "infectious";
    }

    private String insertRelatedTo(String entityName) {
        if (relatedTo3dMapper.isExits(entityName) < 1) {
            relatedTo3dMapper.insertRelatedTo(entityName);
        }
        return "relatedTo";
    }

    private String insertSymptomAndSign(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (symptomAndSign3dMapper.isExits(entityName) >= 1) {
            return "symptomAndSign";
        } else {
            symptomAndSign3dMapper.insertSymptomAndSign(entityName);
        }
        return "symptomAndSign";
    }

    private String insertAuxiliaryExamination(String entityName) {
        if (check3dMapper.isExits(entityName) >= 1) {
            return "check";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "checkSubject";
        } else if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "auxiliaryExamination";
        } else {
            auxiliaryExamination3dMapper.insertAuxiliaryExamination(entityName);
        }
        return "auxiliaryExamination";
    }

    private String insertDrugTherapy(String entityName) {
        if (drug3dMapper.isExits(entityName) >= 1) {
            return "drug";
        } else if (drugTherapy3dMapper.isExits(entityName) >= 1) {
            return "drugTherapy";
        } else {
            drugTherapy3dMapper.insertDrugTherapy(entityName);
        }
        return "drugTherapy";
    }

    private String insertStage(String entityName) {
        if (stage3dMapper.isExits(entityName) < 1) {
            stage3dMapper.insertStage(entityName);
        }
        return "stage";
    }

    private String insertPrevention(String entityName) {
        if (prevention3dMapper.isExits(entityName) < 1) {
            prevention3dMapper.insertPrevention(entityName);
        }
        return "prevention";
    }

    private String insertSpreadWay(String entityName) {
        if (spreadWay3dMapper.isExits(entityName) < 1) {
            spreadWay3dMapper.insertSpreadWay(entityName);
        }
        return "spreadWay";
    }

    //药物

    private String insertType(String entityName) {
        if (type3dMapper.isExits(entityName) < 1) {
            type3dMapper.insertType(entityName);
        }
        return "type";
    }

    private String insertPrecautions(String entityName) {
        if (precautions3dMapper.isExits(entityName) < 1) {
            precautions3dMapper.insertPrecautions(entityName);
        }
        return " precautions";
    }

    private String insertContraindications(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "complication";
        } else if (contraindications3dMapper.isExits(entityName) >= 1) {
            return "contraindications";
        } else {
            contraindications3dMapper.insertContraindications(entityName);
        }
        return "contraindications";
    }

    private String insertSubject(String entityName) {
        if (subject3dMapper.isExits(entityName) < 1) {
            subject3dMapper.insertSubject(entityName);
        }
        return "subject";
    }

    private String insertIngredients(String entityName) {
        if (ingredients3dMapper.isExits(entityName) < 1) {
            ingredients3dMapper.insertIngredients(entityName);
        }
        return "ingredients";
    }

    private String insertOtc(String entityName) {
        if (otc3dMapper.isExits(entityName) < 1) {
            otc3dMapper.insertOTC(entityName);
        }
        return "OTC";
    }

    private String insertAdverseReactions(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "complication";
        } else if (adverseReactions3dMapper.isExits(entityName) >= 1) {
            return "adverseReactions";
        } else {
            adverseReactions3dMapper.insertAdverseReactions(entityName);
        }
        return "adverseReactions";
    }

    private String insertIndications(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "complication";
        } else if (indications3dMapper.isExits(entityName) >= 1) {
            return "indications";
        } else {
            indications3dMapper.insertIndications(entityName);
        }
        return "indications";
    }

    //诊疗

    private String insertCheckSubject(String entityName) {
        if (check3dMapper.isExits(entityName) >= 1) {
            return "check";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "checkSubject";
        } else {
            checkSubject3dMapper.insertCheckSubject(entityName);
        }
        return "checkSubject";
    }

}
