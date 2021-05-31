package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Infectious3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("InfectiousInsertEntityStrategy")
public class InfectiousInsertEntityStrategy implements InsertEntityStrategy {

    final private Infectious3dMapper infectious3dMapper;

    @Autowired
    public InfectiousInsertEntityStrategy(Infectious3dMapper infectious3dMapper) {
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
