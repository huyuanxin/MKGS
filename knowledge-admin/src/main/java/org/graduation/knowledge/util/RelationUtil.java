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
    public LinkedHashMap<String, String> entityTypeMap = new LinkedHashMap<>(64);
    public LinkedHashMap<String, String> relationMap = new LinkedHashMap<>(128);

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

    public String mappingEntityMap(String key) {
        return Optional.ofNullable(entityTypeMap.get(key)).orElse(key);
    }

    public String mappingRelationMap(String key) {
        return Optional.ofNullable(relationMap.get(key)).orElse(key);
    }

    private void init() {
        initEntityTypeMap();
        initRelationMap();
    }

    private void initRelationMap() {
        relationMap.put("科室", "department");
        relationMap.put("发病部位", "diseaseSite");
        relationMap.put("易感人群", "multipleGroups");
        relationMap.put("病因", "cause");
        relationMap.put("预后生存时间", "prognosticSurvivalTime");
        relationMap.put("高位风险因素", "highRiskFactors");
        relationMap.put("相关疾病", "relatedDisease");
        relationMap.put("相关并发症", "relatedSymptom");
        relationMap.put("治疗方案", "treatmentPrograms");
        relationMap.put("症状和体征", "symptomAndSign");
        relationMap.put("预后", "prognosis");
        relationMap.put("发病率", "diseaseRate");
        relationMap.put("药物治疗", "drugTherapy");
        relationMap.put("辅助治疗", "adjuvantTherapy");
        relationMap.put("发病机制", "pathogenesis");
        relationMap.put("手术", "operation");
        relationMap.put("病理类型", "pathologicalType");
        relationMap.put("诊断", "diagnosis");
        relationMap.put("传播方式", "diagnosis");
        relationMap.put("预防", "prevention");
        relationMap.put("不良反应", "adverseReactions");
        relationMap.put("适应症", "indications");
        relationMap.put("禁忌症", "contraindications");
        relationMap.put("检查", "check");
        relationMap.put("并发症", "complication");
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

    public void neo4jEntityTypeUnwrap(Entity entity) {
        entity.setEntityType(StrUtil.unWrap(entity.getEntityType(), "[\"", "\"]"));
    }
}
