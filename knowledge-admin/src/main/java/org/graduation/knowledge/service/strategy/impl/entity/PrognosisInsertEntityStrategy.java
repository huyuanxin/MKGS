package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Prognosis3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PrognosisInsertEntityStrategy")
public class PrognosisInsertEntityStrategy implements InsertEntityStrategy {

    final private Prognosis3dMapper prognosis3dMapper;

    @Autowired
    public PrognosisInsertEntityStrategy(Prognosis3dMapper prognosis3dMapper) {
        this.prognosis3dMapper = prognosis3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (prognosis3dMapper.isExits(entityName) < 1) {
            prognosis3dMapper.insertPrognosis(entityName);
        }
        return "PrognosticSurvivalTime";
    }

}
