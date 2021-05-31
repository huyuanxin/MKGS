package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Attribute3dMapper;
import org.graduation.knowledge.mapper.neo4j.DiseaseRate3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DiseaseRateInsertEntityStrategy")
public class DiseaseRateInsertEntityStrategy implements InsertEntityStrategy {

    final private Attribute3dMapper attribute3dMapper;
    final private DiseaseRate3dMapper diseaseRate3dMapper;

    @Autowired
    public DiseaseRateInsertEntityStrategy(Attribute3dMapper attribute3dMapper, DiseaseRate3dMapper diseaseRate3dMapper) {
        this.attribute3dMapper = attribute3dMapper;
        this.diseaseRate3dMapper = diseaseRate3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (attribute3dMapper.isExits(entityName) >= 1) {
            return "Attribute";
        } else if (diseaseRate3dMapper.isExits(entityName) >= 1) {
            return "DiseaseRate";
        } else {
            diseaseRate3dMapper.insertDiseaseRate(entityName);
        }
        return "DiseaseRate";
    }

}
