package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Drug3dMapper;
import org.graduation.knowledge.mapper.neo4j.DrugTherapy3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DrugTherapyInsertEntityStrategy")
public class DrugTherapyInsertEntityStrategy implements InsertEntityStrategy {

    final private Drug3dMapper drug3dMapper;
    final private DrugTherapy3dMapper drugTherapy3dMapper;

    @Autowired
    public DrugTherapyInsertEntityStrategy(Drug3dMapper drug3dMapper, DrugTherapy3dMapper drugTherapy3dMapper) {
        this.drug3dMapper = drug3dMapper;
        this.drugTherapy3dMapper = drugTherapy3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (drug3dMapper.isExits(entityName) >= 1) {
            return "Drug";
        } else if (drugTherapy3dMapper.isExits(entityName) >= 1) {
            return "DrugTherapy";
        } else {
            drugTherapy3dMapper.insertDrugTherapy(entityName);
        }
        return "DrugTherapy";
    }

}
