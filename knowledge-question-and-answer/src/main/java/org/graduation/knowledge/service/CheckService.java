package org.graduation.knowledge.service;

import org.graduation.knowledge.model.node.Disease;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface CheckService {

    /**
     * 已知检查查询疾病
     *
     * @param checkName 检查名
     * @return 已知检查查询疾病
     */
    List<Disease> getDiseaseByCheckName(String checkName);

}
