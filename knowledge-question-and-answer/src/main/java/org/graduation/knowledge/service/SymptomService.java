package org.graduation.knowledge.service;

import org.graduation.knowledge.model.node.Disease;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface SymptomService {

    /**
     * 查询症状会导致哪些疾病
     *
     * @param symptomName 症状名
     * @return 查询症状会导致哪些疾病
     */
    List<Disease> getDiseaseBySymptom(String symptomName);
}
