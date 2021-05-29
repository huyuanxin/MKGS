package org.graduation.knowledge.service.common;

import org.graduation.knowledge.observer.Subject;

import java.util.HashMap;

/**
 * @author huyuanxin
 */
public interface ImportEntityService extends Subject {

    /**
     * 保存实体
     *
     * @param entities 前端的保存的结果中的entities
     */
    void importEntity(HashMap<String, String> entities);

}
