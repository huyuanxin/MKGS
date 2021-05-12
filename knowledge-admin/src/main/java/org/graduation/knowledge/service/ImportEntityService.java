package org.graduation.knowledge.service;

import java.util.HashMap;

/**
 * @author huyuanxin
 */
public interface ImportEntityService {

    /**
     * 保存实体
     *
     * @param entities 前端的保存的结果中的entities
     */
    void importEntity(HashMap<String, String> entities);

}
