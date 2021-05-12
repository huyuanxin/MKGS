package org.graduation.knowledge.factory;


import org.graduation.knowledge.model.node.*;
import org.graduation.knowledge.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huyuanxin
 */
@Component
public class AnswerFactory {

    final CheckService checkService;
    final DiseaseService diseaseService;
    final DrugService drugService;
    final FoodService foodService;
    final SymptomService symptomService;

    @Autowired
    public AnswerFactory(CheckService checkService, DiseaseService diseaseService, DrugService drugService, FoodService foodService, SymptomService symptomService) {
        this.checkService = checkService;
        this.diseaseService = diseaseService;
        this.drugService = drugService;
        this.foodService = foodService;
        this.symptomService = symptomService;
    }

    public String answerSearch(String entity, String questionType) {
        StringBuilder answer = new StringBuilder();
        switch (questionType) {
            case "disease_cause": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append("可能的成因有").append(disease.getCause());
                }
                break;
            }
            case "disease_prevent": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append("的预防措施包括：").append(disease.getPrevent());
                }
                break;
            }
            case "disease_lasttime": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append("治疗可能持续的周期为：").append(disease.getCureLastTime());
                }
                break;
            }
            case "disease_cureprob": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append("治愈的概率为（仅供参考）：").append(disease.getCuredProb());
                }
                break;
            }
            case "disease_cureway": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append("可以尝试如下治疗：").append(disease.getCureWayFormat());
                }
                break;
            }
            case "disease_easyget": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append("的易感人群包括：").append(disease.getEasyGet());
                }
                break;
            }
            case "disease_desc": {
                Disease disease = diseaseService.getDiseaseByDiseaseName(entity);
                if (disease != null) {
                    answer.append(entity).append(",熟悉一下：").append(disease.getDesc());
                }
                break;
            }
            case "disease_symptom": {
                List<Symptom> symptomList = diseaseService.getSymptomByDiseaseName(entity);
                if (symptomList != null) {
                    answer.append(entity).append("的症状包括：");
                    for (Symptom symptom : symptomList) {
                        answer.append(symptom.getName()).append(",");
                    }
                }
                break;
            }
            case "symptom_disease": {
                List<Disease> diseaseList = symptomService.getDiseaseBySymptom(entity);
                if (diseaseList != null) {
                    answer.append("症状").append(entity).append("可能染上的疾病有：");
                    for (Disease disease : diseaseList) {
                        answer.append(disease.getName()).append(",");
                    }
                }
                break;
            }
            case "disease_acompany": {
                List<Disease> diseaseList = diseaseService.getAccompanyByDiseaseName(entity);
                if (diseaseList != null) {
                    answer.append(entity).append("的并发症症状包括：");
                    for (Disease disease : diseaseList) {
                        answer.append(disease.getName()).append(",");
                    }
                }
                List<Disease> diseaseListReverse = diseaseService.getAccompanyReverseByDiseaseName(entity);
                if (diseaseListReverse != null) {
                    for (Disease disease : diseaseListReverse) {
                        answer.append(disease.getName()).append(",");
                    }
                }
                break;
            }
            case "disease_not_food": {
                List<Food> foodList = diseaseService.getNotEatFoodByDiseaseName(entity);
                if (foodList != null) {
                    answer.append(entity).append("忌食的食物包括有：");
                    for (Food food : foodList) {
                        answer.append(food.getName()).append(",");
                    }
                }
                break;
            }
            case "disease_do_food": {
                List<Food> foodList = diseaseService.getRecommendFoodByDiseaseName(entity);
                if (foodList != null) {
                    answer.append(entity).append("宜食的食物包括有：");
                    for (Food food : foodList) {
                        answer.append(food.getName()).append(",");
                    }
                }
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                answer.append("。");
                List<Food> recipeList = diseaseService.getRecommendRecipeByDiseaseName(entity);
                if (foodList != null) {
                    answer.append(entity).append("推荐食谱包括有：");
                    for (Food food : recipeList) {
                        answer.append(food.getName()).append(",");
                    }
                }
                break;
            }
            case "food_not_disease": {
                List<Disease> diseaseList = foodService.getDiseaseByNotToEat(entity);
                if (diseaseList != null) {
                    answer.append("患有");
                    for (Disease disease : diseaseList) {
                        answer.append(disease.getName()).append(",");
                    }

                    answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                    answer.append("的人最好不要吃").append(entity).append(",");
                }
                break;
            }
            case "food_do_disease": {
                List<Disease> diseaseList = foodService.getDiseaseByGoodToEat(entity);
                diseaseList.addAll(foodService.getDiseaseByRecommendToEat(entity));
                answer.append("患有");
                for (Disease disease : diseaseList) {
                    answer.append(disease.getName()).append(",");
                }
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                answer.append("的人建议多试试").append(entity).append(",");
                break;
            }
            case "disease_drug": {
                List<Drug> drugList = diseaseService.getCommonDrugByDiseaseName(entity);
                drugList.addAll(diseaseService.getRecommendDrugByDiseaseName(entity));
                answer.append(entity).append("通常的使用的药品包括");
                for (Drug drug : drugList) {
                    answer.append(drug.getName()).append(",");
                }
                break;
            }
            case "drug_disease": {
                List<Disease> diseaseList = drugService.getDiseaseByCommonDrug(entity);
                diseaseList.addAll(drugService.getDiseaseByRecommendDrug(entity));
                answer.append(entity).append("主治的疾病有：");
                for (Disease disease : diseaseList) {
                    answer.append(disease.getName()).append(",");
                }
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                answer.append(",可以试试").append(entity).append(",");
                break;
            }
            case "disease_check": {
                List<Check> checkList = diseaseService.getCheckByDiseaseName(entity);
                if (checkList != null) {
                    answer.append(entity).append("通常可以通过以下方式检查出来：");
                    for (Check check : checkList) {
                        answer.append(check.getName()).append(",");
                    }
                }
                break;
            }
            case "check_disease": {
                List<Disease> diseaseList = checkService.getDiseaseByCheckName(entity);
                if (diseaseList != null) {
                    answer.append("通常可以通过").append(entity).append("检查出来的疾病有：");
                    for (Disease disease : diseaseList) {
                        answer.append(disease.getName()).append(",");
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        if (answer.toString().endsWith("。")) {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }
        if (answer.length() > 0) {
            answer = new StringBuilder(answer.substring(0, answer.length()) + "。");
        }

        return answer.toString();
    }
}
