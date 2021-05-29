package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.AuxiliaryExamination3dMapper;
import org.graduation.knowledge.mapper.neo4j.Check3dMapper;
import org.graduation.knowledge.mapper.neo4j.CheckSubject3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("AuxiliaryExaminationInsertStrategy")
public class AuxiliaryExaminationInsertStrategy implements InsertStrategy {

    final private Check3dMapper check3dMapper;
    final private CheckSubject3dMapper checkSubject3dMapper;
    final private AuxiliaryExamination3dMapper auxiliaryExamination3dMapper;

    @Autowired
    public AuxiliaryExaminationInsertStrategy(Check3dMapper check3dMapper, CheckSubject3dMapper checkSubject3dMapper, AuxiliaryExamination3dMapper auxiliaryExamination3dMapper) {
        this.check3dMapper = check3dMapper;
        this.checkSubject3dMapper = checkSubject3dMapper;
        this.auxiliaryExamination3dMapper = auxiliaryExamination3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "CheckSubject";
        } else if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "AuxiliaryExamination";
        } else {
            auxiliaryExamination3dMapper.insertAuxiliaryExamination(entityName);
        }
        return "AuxiliaryExamination";
    }

}
