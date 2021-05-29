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
@Service("CheckInsertStrategy")
public class CheckInsertStrategy implements InsertStrategy {

    final private AuxiliaryExamination3dMapper auxiliaryExamination3dMapper;
    final private CheckSubject3dMapper checkSubject3dMapper;
    final private Check3dMapper check3dMapper;

    @Autowired
    public CheckInsertStrategy(AuxiliaryExamination3dMapper auxiliaryExamination3dMapper, CheckSubject3dMapper checkSubject3dMapper, Check3dMapper check3dMapper) {
        this.auxiliaryExamination3dMapper = auxiliaryExamination3dMapper;
        this.checkSubject3dMapper = checkSubject3dMapper;
        this.check3dMapper = check3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (auxiliaryExamination3dMapper.isExits(entityName) >= 1) {
            return "AuxiliaryExamination";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "CheckSubject";
        } else if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else {
            check3dMapper.insertCheck(entityName);
        }
        return "Check";
    }

}
