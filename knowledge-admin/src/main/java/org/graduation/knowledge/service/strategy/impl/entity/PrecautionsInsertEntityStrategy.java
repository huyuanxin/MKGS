package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Precautions3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PrecautionsInsertEntityStrategy")
public class PrecautionsInsertEntityStrategy implements InsertEntityStrategy {

    final private Precautions3dMapper precautions3dMapper;

    @Autowired
    public PrecautionsInsertEntityStrategy(Precautions3dMapper precautions3dMapper) {
        this.precautions3dMapper = precautions3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (precautions3dMapper.isExits(entityName) < 1) {
            precautions3dMapper.insertPrecautions(entityName);
        }
        return "Precautions";
    }

}
