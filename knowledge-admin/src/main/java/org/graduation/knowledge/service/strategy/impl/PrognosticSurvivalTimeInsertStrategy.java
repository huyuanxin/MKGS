package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.PrognosticSurvivalTime3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PrognosticSurvivalTimeInsertStrategy")
public class PrognosticSurvivalTimeInsertStrategy implements InsertStrategy {

    final private PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper;

    @Autowired
    public PrognosticSurvivalTimeInsertStrategy(PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper) {
        this.prognosticSurvivalTime3dMapper = prognosticSurvivalTime3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (prognosticSurvivalTime3dMapper.isExits(entityName) < 1) {
            prognosticSurvivalTime3dMapper.insertPrognosticSurvivalTime(entityName);
        }
        return "PrognosticSurvivalTime";
    }

}
