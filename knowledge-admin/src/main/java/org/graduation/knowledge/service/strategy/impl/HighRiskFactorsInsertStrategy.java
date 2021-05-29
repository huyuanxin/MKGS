package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.HighRiskFactors3dMapper;
import org.graduation.knowledge.mapper.neo4j.PrognosticSurvivalTime3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("HighRiskFactorsInsertStrategy")
public class HighRiskFactorsInsertStrategy implements InsertStrategy {

    final private PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper;
    final private HighRiskFactors3dMapper highRiskFactors3dMapper;

    @Autowired
    public HighRiskFactorsInsertStrategy(PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper, HighRiskFactors3dMapper highRiskFactors3dMapper) {
        this.prognosticSurvivalTime3dMapper = prognosticSurvivalTime3dMapper;
        this.highRiskFactors3dMapper = highRiskFactors3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (prognosticSurvivalTime3dMapper.isExits(entityName) >= 1) {
            return "PrognosticSurvivalTime";
        } else if (highRiskFactors3dMapper.isExits(entityName) >= 1) {
            return "HighRiskFactors";
        } else {
            highRiskFactors3dMapper.insertHighRiskFactors(entityName);
        }
        return "HighRiskFactors";
    }

}
