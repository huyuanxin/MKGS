package org.graduation.knowledge.service;

import org.graduation.knowledge.model.node.Disease;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface DrugService {

    /**
     * 已知药品查询能够治疗的疾病
     *
     * @param drugName 药品名
     * @return 已知药品查询能够治疗的疾病
     */
    List<Disease> getDiseaseByCommonDrug(String drugName);

    /**
     * 已知药品查询能够治疗的疾病
     *
     * @param drugName 药品名
     * @return 已知药品查询能够治疗的疾病
     */
    List<Disease> getDiseaseByRecommendDrug(String drugName);
}
