package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Diagnosis3dMapper;
import org.graduation.knowledge.mapper.neo4j.Treatment3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DiagnosisInsertEntityStrategy")
public class DiagnosisInsertEntityStrategy implements InsertEntityStrategy {

    final private Treatment3dMapper treatment3dMapper;
    final private Diagnosis3dMapper diagnosis3dMapper;

    @Autowired
    public DiagnosisInsertEntityStrategy(Treatment3dMapper treatment3dMapper, Diagnosis3dMapper diagnosis3dMapper) {
        this.treatment3dMapper = treatment3dMapper;
        this.diagnosis3dMapper = diagnosis3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (treatment3dMapper.isExits(entityName) >= 1) {
            return "Treatment";
        } else if (diagnosis3dMapper.isExits(entityName) >= 1) {
            return "Diagnosis";
        } else {
            diagnosis3dMapper.insertDiagnosis(entityName);
        }
        return "Diagnosis";
    }

}
