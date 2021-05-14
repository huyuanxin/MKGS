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
            case "Disease": {
                return insertDisease(entityName);
            }
            case "Symptom": {
                return insertSymptom(entityName);
            }
            case "Complication": {
                return insertComplication(entityName);
            }
            case "PathologicalType": {
                return insertPathologicalType(entityName);
            }
            case "Treatment": {
                return insertTreatment(entityName);
            }
            case "Diagnosis": {
                return insertDiagnosis(entityName);
            }
            case "Pathophysiology": {
                return insertPathophysiology(entityName);
            }
            case "DiseaseSite": {
                return insertDiseaseSite(entityName);
            }
            case "Department": {
                return insertDepartment(entityName);
            }
            case "MultipleGroups": {
                return insertMultipleGroups(entityName);
            }
            case "Cause": {
                return insertCause(entityName);
            }
            case "PrognosticSurvivalTime": {
                return insertPrognosticSurvivalTime(entityName);
            }
            case "HighRiskFactors": {
                return insertHighRiskFactors(entityName);
            }
            case "Prognosis": {
                return insertPrognosis(entityName);
            }
            case "Attribute": {
                return insertAttribute(entityName);
            }
            case "DiseaseRate": {
                return insertDiseaseRate(entityName);
            }
            case "Drug": {
                return insertDrug(entityName);
            }
            case "Operation": {
                return insertOperation(entityName);
            }
            case "Pathogenesis": {
                return insertPathogenesis(entityName);
            }
            case "TreatmentPrograms": {
                return insertTreatmentPrograms(entityName);

            }
            case "RelatedSymptom": {
                return insertRelatedSymptom(entityName);
            }
            case "Check": {
                return insertCheck(entityName);

            }
            case "RelatedDisease": {
                return insertRelatedDisease(entityName);

            }
            case "AdjuvantTherapy": {
                return insertAdjuvantTherapy(entityName);

            }
            case "Infectious": {
                return insertInfectious(entityName);
            }
            case "RelatedTo": {
                return insertRelatedTo(entityName);
            }
            case "SymptomAndSign": {
                return insertSymptomAndSign(entityName);
            }
            case "AuxiliaryExamination": {
                return insertAuxiliaryExamination(entityName);
            }
            case "DrugTherapy": {
                return insertDrugTherapy(entityName);
            }
            case "Stage": {
                return insertStage(entityName);
            }
            case "Prevention": {
                return insertPrevention(entityName);
            }
            case "SpreadWay": {
                return insertSpreadWay(entityName);
            }
            case "Type": {
                return insertType(entityName);
            }
            case "Precautions": {
                return insertPrecautions(entityName);
            }
            case "Contraindications": {
                return insertContraindications(entityName);
            }
            case "Subject": {
                return insertSubject(entityName);
            }
            case "Ingredients": {
                return insertIngredients(entityName);
            }
            case "OTC": {
                return insertOtc(entityName);
            }
            case "AdverseReactions": {
                return insertAdverseReactions(entityName);
            }
            case "Indications": {
                return insertIndications(entityName);
            }
            case "CheckSubject": {
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
            return "Symptom";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else {
            disease3dMapper.insertDisease(entityName);
        }
        return "Disease";
    }

    private String insertSymptom(String entityName) {
        if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else {
            symptom3dMapper.insertSymptom(entityName);
        }
        return "Symptom";
    }

    private String insertComplication(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "Complication";
        } else {
            complication3dMapper.insertComplication(entityName);
        }
        return "Complication";
    }

    private String insertPathologicalType(String entityName) {
        if (pathologicalType3dMapper.isExits(entityName) < 1) {
            pathologicalType3dMapper.insertPathologicalType(entityName);
        }
        return "Pathological";
    }

    private String insertTreatment(String entityName) {
        if (treatment3DMapper.isExits(entityName) < 1) {
            treatment3DMapper.insertTreatment(entityName);
        }
        return "Treatment";
    }

    private String insertDiagnosis(String entityName) {
        if (treatment3DMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else if (diagnosis3dMapper.isExits(entityName) >= 1) {
            return "Diagnosis";
        } else {
            diagnosis3dMapper.insertDiagnosis(entityName);
        }
        return "Diagnosis";
    }

    private String insertPathophysiology(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (pathophysiology3dMapper.isExits(entityName) >= 1) {
            return "Pathophysiology";
        } else {
            pathophysiology3dMapper.insertPathophysiology(entityName);
        }
        return "Pathophysiology";
    }

    private String insertDepartment(String entityName) {
        if (department3dMapper.isExits(entityName) < 1) {
            department3dMapper.insertDepartment(entityName);
        }
        return "Department";
    }

    private String insertMultipleGroups(String entityName) {
        if (multipleGroups3dMapper.isExits(entityName) < 1) {
            multipleGroups3dMapper.insertMultipleGroups(entityName);
        }
        return "MultipleGroups";
    }

    private String insertCause(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (cause3dMapper.isExits(entityName) >= 1) {
            return "Cause";
        } else {
            cause3dMapper.insertCause(entityName);
        }
        return "Cause";
    }

    private String insertPrognosticSurvivalTime(String entityName) {
        if (prognosticSurvivalTime3dMapper.isExits(entityName) < 1) {
            prognosticSurvivalTime3dMapper.insertPrognosticSurvivalTime(entityName);
        }
        return "PrognosticSurvivalTime";
    }

    private String insertHighRiskFactors(String entityName) {
        if (prognosticSurvivalTime3dMapper.isExits(entityName) < 1) {
            highRiskFactors3dMapper.insertHighRiskFactors(entityName);
        }
        return "HrognosticSurvivalTime";
    }

    public String insertPrognosis(String entityName) {
        if (prognosis3dMapper.isExits(entityName) < 1) {
            prognosis3dMapper.insertPrognosis(entityName);
        }
        return "PrognosticSurvivalTime";
    }

    public String insertAttribute(String entityName) {
        if (attribute3dMapper.isExits(entityName) < 1) {
            attribute3dMapper.insertAttribute(entityName);
        }
        return "Attribute";
    }

    public String insertDiseaseRate(String entityName) {
        if (attribute3dMapper.isExits(entityName) >= 1) {
            return "Attribute";
        } else if (diseaseRate3dMapper.isExits(entityName) >= 1) {
            return "DiseaseRate";
        } else {
            diseaseRate3dMapper.insertDiseaseRate(entityName);
        }
        return "DiseaseRate";
    }

    public String insertDrug(String entityName) {
        if (drug3dMapper.isExits(entityName) < 1) {
            drug3dMapper.insertDrug(entityName);
        }
        return "Drug";
    }

    public String insertOperation(String entityName) {
        if (treatment3DMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else if (operation3dMapper.isExits(entityName) >= 1) {
            return "Operation";
        } else {
            operation3dMapper.insertOperation(entityName);
        }
        return "Operation";
    }

    private String insertPathogenesis(String entityName) {
        if (pathogenesis3dMapper.isExits(entityName) < 1) {
            pathogenesis3dMapper.insertPathogenesis(entityName);
        }
        return "Pathogenesis";
    }

    private String insertTreatmentPrograms(String entityName) {
        if (adjuvantTherapy3dMapper.isExits(entityName) >= 1) {
            return "AdjuvantTherapy";
        } else if (drugTherapy3dMapper.isExits(entityName) >= 1) {
            return "DrugTherapy";
        } else if (drug3dMapper.isExits(entityName) >= 1) {
            return "Drug";
        } else if (treatment3DMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "AuxiliaryExamination";
        } else if (operation3dMapper.isExits(entityName) >= 1) {
            return "Operation";
        } else if (treatmentPrograms3dMapper.isExits(entityName) >= 1) {
            return "TreatmentPrograms";
        } else {
            treatmentPrograms3dMapper.insertTreatmentPrograms(entityName);
        }
        return "TreatmentPrograms";
    }

    private String insertRelatedSymptom(String entityName) {
        if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (relatedSymptom3dMapper.isExits(entityName) >= 1) {
            return "RelatedSymptom";
        } else {
            relatedSymptom3dMapper.insertRelatedSymptom(entityName);
        }
        return "RelatedSymptom";
    }

    //症状

    private String insertCheck(String entityName) {
        if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "AuxiliaryExamination";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "CheckSubject";
        } else if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else {
            check3dMapper.insertCheck(entityName);
        }
        return "Check";
    }

    private String insertDiseaseSite(String entityName) {
        if (diseaseSite3dMapper.isExits(entityName) >= 1) {
            return "DiseaseSite";
        } else if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else {
            diseaseSite3dMapper.insertDiseaseSite(entityName);
        }
        return "DiseaseSite";
    }

    private String insertRelatedDisease(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (relatedDisease3dMapper.isExits(entityName) >= 1) {
            return "RelatedDisease";
        } else {
            relatedDisease3dMapper.insertRelatedDisease(entityName);
        }
        return "RelatedDisease";
    }

    public String insertAdjuvantTherapy(String entityName) {
        if (adjuvantTherapy3dMapper.isExits(entityName) >= 1) {
            return "AdjuvantTherapy";
        } else if (treatment3DMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else {
            adjuvantTherapy3dMapper.insertAdjuvantTherapy(entityName);
        }
        return "Treatment";
    }

    private String insertInfectious(String entityName) {
        if (infectious3dMapper.isExits(entityName) < 1) {
            infectious3dMapper.insertInfectious(entityName);
        }
        return "Infectious";
    }

    private String insertRelatedTo(String entityName) {
        if (relatedTo3dMapper.isExits(entityName) < 1) {
            relatedTo3dMapper.insertRelatedTo(entityName);
        }
        return "RelatedTo";
    }

    private String insertSymptomAndSign(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (symptomAndSign3dMapper.isExits(entityName) >= 1) {
            return "SymptomAndSign";
        } else {
            symptomAndSign3dMapper.insertSymptomAndSign(entityName);
        }
        return "SymptomAndSign";
    }

    private String insertAuxiliaryExamination(String entityName) {
        if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "CheckSubject";
        } else if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "AuxiliaryExamination";
        } else {
            auxiliaryExamination3dMapper.insertAuxiliaryExamination(entityName);
        }
        return "AuxiliaryExamination";
    }

    private String insertDrugTherapy(String entityName) {
        if (drug3dMapper.isExits(entityName) >= 1) {
            return "Drug";
        } else if (drugTherapy3dMapper.isExits(entityName) >= 1) {
            return "DrugTherapy";
        } else {
            drugTherapy3dMapper.insertDrugTherapy(entityName);
        }
        return "DrugTherapy";
    }

    private String insertStage(String entityName) {
        if (stage3dMapper.isExits(entityName) < 1) {
            stage3dMapper.insertStage(entityName);
        }
        return "Stage";
    }

    private String insertPrevention(String entityName) {
        if (prevention3dMapper.isExits(entityName) < 1) {
            prevention3dMapper.insertPrevention(entityName);
        }
        return "Prevention";
    }

    private String insertSpreadWay(String entityName) {
        if (spreadWay3dMapper.isExits(entityName) < 1) {
            spreadWay3dMapper.insertSpreadWay(entityName);
        }
        return "SpreadWay";
    }

    //药物

    private String insertType(String entityName) {
        if (type3dMapper.isExits(entityName) < 1) {
            type3dMapper.insertType(entityName);
        }
        return "Type";
    }

    private String insertPrecautions(String entityName) {
        if (precautions3dMapper.isExits(entityName) < 1) {
            precautions3dMapper.insertPrecautions(entityName);
        }
        return "Precautions";
    }

    private String insertContraindications(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "Complication";
        } else if (contraindications3dMapper.isExits(entityName) >= 1) {
            return "Contraindications";
        } else {
            contraindications3dMapper.insertContraindications(entityName);
        }
        return "Contraindications";
    }

    private String insertSubject(String entityName) {
        if (subject3dMapper.isExits(entityName) < 1) {
            subject3dMapper.insertSubject(entityName);
        }
        return "Subject";
    }

    private String insertIngredients(String entityName) {
        if (ingredients3dMapper.isExits(entityName) < 1) {
            ingredients3dMapper.insertIngredients(entityName);
        }
        return "Ingredients";
    }

    private String insertOtc(String entityName) {
        if (otc3dMapper.isExits(entityName) < 1) {
            otc3dMapper.insertOTC(entityName);
        }
        return "OTC";
    }

    private String insertAdverseReactions(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "Complication";
        } else if (adverseReactions3dMapper.isExits(entityName) >= 1) {
            return "AdverseReactions";
        } else {
            adverseReactions3dMapper.insertAdverseReactions(entityName);
        }
        return "adverseReactions";
    }

    private String insertIndications(String entityName) {
        if (disease3dMapper.isExits(entityName) >= 1) {
            return "Disease";
        } else if (symptom3dMapper.isExits(entityName) >= 1) {
            return "Symptom";
        } else if (complication3dMapper.isExits(entityName) >= 1) {
            return "Complication";
        } else if (indications3dMapper.isExits(entityName) >= 1) {
            return "Indications";
        } else {
            indications3dMapper.insertIndications(entityName);
        }
        return "indications";
    }

    //诊疗

    private String insertCheckSubject(String entityName) {
        if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "CheckSubject";
        } else {
            checkSubject3dMapper.insertCheckSubject(entityName);
        }
        return "CheckSubject";
    }

}
