package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Attribute3dMapper;
import org.graduation.knowledge.mapper.neo4j.DiseaseRate3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DiseaseRateInsertStrategy")
public class DiseaseRateInsertStrategy implements InsertStrategy {

    final private Attribute3dMapper attribute3dMapper;
    final private DiseaseRate3dMapper diseaseRate3dMapper;

    @Autowired
    public DiseaseRateInsertStrategy(Attribute3dMapper attribute3dMapper, DiseaseRate3dMapper diseaseRate3dMapper) {
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
