package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Stage3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("StageInsertStrategy")
public class StageInsertStrategy implements InsertStrategy {

    final private Stage3dMapper stage3dMapper;

    @Autowired
    public StageInsertStrategy(Stage3dMapper stage3dMapper) {
        this.stage3dMapper = stage3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (stage3dMapper.isExits(entityName) < 1) {
            stage3dMapper.insertStage(entityName);
        }
        return "Stage";
    }

}
