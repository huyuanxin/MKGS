package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Infectious3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("InfectiousInsertStrategy")
public class InfectiousInsertStrategy implements InsertStrategy {

    final private Infectious3dMapper infectious3dMapper;

    @Autowired
    public InfectiousInsertStrategy(Infectious3dMapper infectious3dMapper) {
        this.infectious3dMapper = infectious3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (infectious3dMapper.isExits(entityName) < 1) {
            infectious3dMapper.insertInfectious(entityName);
        }
        return "Infectious";
    }

}
