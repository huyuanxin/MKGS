package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Drug3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DrugInsertEntityStrategy")
public class DrugInsertEntityStrategy implements InsertEntityStrategy {

    final private Drug3dMapper drug3dMapper;

    @Autowired
    public DrugInsertEntityStrategy(Drug3dMapper drug3dMapper) {
        this.drug3dMapper = drug3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (drug3dMapper.isExits(entityName) < 1) {
            drug3dMapper.insertDrug(entityName);
        }
        return "Drug";
    }

}
