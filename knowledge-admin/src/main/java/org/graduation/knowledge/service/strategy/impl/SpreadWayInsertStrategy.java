package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.SpreadWay3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("SpreadWayInsertStrategy")
public class SpreadWayInsertStrategy implements InsertStrategy {

    final private SpreadWay3dMapper spreadWay3dMapper;

    @Autowired
    public SpreadWayInsertStrategy(SpreadWay3dMapper spreadWay3dMapper) {
        this.spreadWay3dMapper = spreadWay3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (spreadWay3dMapper.isExits(entityName) < 1) {
            spreadWay3dMapper.insertSpreadWay(entityName);
        }
        return "SpreadWay";
    }

}
