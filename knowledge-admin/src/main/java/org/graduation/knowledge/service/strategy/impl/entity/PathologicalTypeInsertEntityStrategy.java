package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.PathologicalType3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PathologicalTypeInsertEntityStrategy")
public class PathologicalTypeInsertEntityStrategy implements InsertEntityStrategy {

    final private PathologicalType3dMapper pathologicalType3dMapper;

    @Autowired
    public PathologicalTypeInsertEntityStrategy(PathologicalType3dMapper pathologicalType3dMapper) {
        this.pathologicalType3dMapper = pathologicalType3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (pathologicalType3dMapper.isExits(entityName) < 1) {
            pathologicalType3dMapper.insertPathologicalType(entityName);
        }
        return "Pathological";
    }

}
