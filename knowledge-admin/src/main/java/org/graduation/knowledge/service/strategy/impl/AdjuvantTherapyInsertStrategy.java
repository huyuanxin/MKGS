package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.AdjuvantTherapy3dMapper;
import org.graduation.knowledge.mapper.neo4j.Treatment3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("AdjuvantTherapyInsertStrategy")
public class AdjuvantTherapyInsertStrategy implements InsertStrategy {

    final private AdjuvantTherapy3dMapper adjuvantTherapy3dMapper;
    final private Treatment3dMapper treatment3dMapper;

    @Autowired
    public AdjuvantTherapyInsertStrategy(AdjuvantTherapy3dMapper adjuvantTherapy3dMapper, Treatment3dMapper treatment3dMapper) {
        this.adjuvantTherapy3dMapper = adjuvantTherapy3dMapper;
        this.treatment3dMapper = treatment3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (adjuvantTherapy3dMapper.isExits(entityName) >= 1) {
            return "AdjuvantTherapy";
        } else if (treatment3dMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else {
            adjuvantTherapy3dMapper.insertAdjuvantTherapy(entityName);
        }
        return "Treatment";
    }

}
