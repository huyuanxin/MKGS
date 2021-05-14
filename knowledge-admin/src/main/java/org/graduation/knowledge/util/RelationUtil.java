package org.graduation.knowledge.util;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.graduation.knowledge.model.Entity;

import java.util.LinkedHashMap;
import java.util.Optional;

/**
 * @author huyuanxin
 */
@Data
public class RelationUtil {

    private static volatile RelationUtil instance = null;
    private static LinkedHashMap<String, String> entityTypeMap = new LinkedHashMap<>(64);
    private static LinkedHashMap<String, String> allRelationMap = new LinkedHashMap<>(128);

    private RelationUtil() {
        init();
    }

    public static RelationUtil getInstance() {
        if (instance == null) {
            synchronized (RelationUtil.class) {
                if (instance == null) {
                    instance = new RelationUtil();
                }
            }
        }
        return instance;
    }

    private void init() {
        initEntityTypeMap();
        initRelationMap();
    }

    public String mappingEntityMap(String key) {
        return Optional.ofNullable(entityTypeMap.get(key)).orElse(key);
    }

    public String mappingRelationMap(String key) {
        return Optional.ofNullable(allRelationMap.get(key)).orElse(key);
    }

    public void neo4jEntityTypeUnwrap(Entity entity) {
        entity.setEntityType(StrUtil.unWrap(entity.getEntityType(), "[\"", "\"]"));
    }

    private void initRelationMap() {
        allRelationMap.put("科室", "department");
        allRelationMap.put("发病部位", "diseaseSite");
        allRelationMap.put("易感人群", "multipleGroups");
        allRelationMap.put("病因", "cause");
        allRelationMap.put("预后生存时间", "prognosticSurvivalTime");
        allRelationMap.put("高位风险因素", "highRiskFactors");
        allRelationMap.put("相关疾病", "relatedDisease");
        allRelationMap.put("相关并发症", "relatedSymptom");
        allRelationMap.put("治疗方案", "treatmentPrograms");
        allRelationMap.put("症状和体征", "symptomAndSign");
        allRelationMap.put("预后", "prognosis");
        allRelationMap.put("发病率", "diseaseRate");
        allRelationMap.put("药物治疗", "drugTherapy");
        allRelationMap.put("辅助治疗", "adjuvantTherapy");
        allRelationMap.put("发病机制", "pathogenesis");
        allRelationMap.put("手术", "operation");
        allRelationMap.put("病理类型", "pathologicalType");
        allRelationMap.put("诊断", "diagnosis");
        allRelationMap.put("传播方式", "diagnosis");
        allRelationMap.put("预防", "prevention");
        allRelationMap.put("不良反应", "adverseReactions");
        allRelationMap.put("适应症", "indications");
        allRelationMap.put("禁忌症", "contraindications");
        allRelationMap.put("检查", "check");
        allRelationMap.put("并发症", "complication");

    }

    private void initEntityTypeMap() {
        entityTypeMap.put("疾病", "disease");
        entityTypeMap.put("并发症", "complication");
        entityTypeMap.put("临床症状及体征", "symptomAndSign");
        entityTypeMap.put("预后状况", "Prognosis");
        entityTypeMap.put("发病率", "diseaseRate");
        entityTypeMap.put("药物治疗", "drugTherapy");
        entityTypeMap.put("辅助治疗", "adjuvantTherapy");
        entityTypeMap.put("手术治疗", "operation");
        entityTypeMap.put("发病机制", "pathogenesis");
        entityTypeMap.put("病理分型", "pathologicalType");
        entityTypeMap.put("鉴别诊断", "diagnosis");
        entityTypeMap.put("病理生理", "pathophysiology");
        entityTypeMap.put("发病部位", "diseaseSite");
        entityTypeMap.put("所属科室", "department");
        entityTypeMap.put("多发群体", "multipleGroups");
        entityTypeMap.put("病因", "cause");
        entityTypeMap.put("预后生存时间", "prognosticSurvivalTime");
        entityTypeMap.put("高危因素", "highRiskFactors");
        entityTypeMap.put("治疗方案", "treatmentPrograms");
        entityTypeMap.put("相关疾病", "relatedDisease");
        entityTypeMap.put("相关症状", "relatedSymptom");
        entityTypeMap.put("辅助检查", "auxiliaryExamination");
    }


}
