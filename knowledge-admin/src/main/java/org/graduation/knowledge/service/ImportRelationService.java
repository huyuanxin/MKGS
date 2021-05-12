package org.graduation.knowledge.service;

import org.graduation.knowledge.model.dto.ImportDataDTO;

import java.util.HashMap;

/**
 * @author huyuanxin
 */
public interface ImportRelationService {

    /**
     * 插入关系
     *
     * @param importDataDTO 前端的保存的结果
     * @param entities      前端的保存的结果中的entities
     */
    void insertRelations(ImportDataDTO importDataDTO, HashMap<String, String> entities);

}
