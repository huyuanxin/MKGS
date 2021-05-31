package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.OTC3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("OtcInsertEntityStrategy")
public class OtcInsertEntityStrategy implements InsertEntityStrategy {

    final private OTC3dMapper otc3dMapper;

    @Autowired
    public OtcInsertEntityStrategy(OTC3dMapper otc3dMapper) {
        this.otc3dMapper = otc3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (otc3dMapper.isExits(entityName) < 1) {
            otc3dMapper.insertOTC(entityName);
        }
        return "OTC";
    }

}
