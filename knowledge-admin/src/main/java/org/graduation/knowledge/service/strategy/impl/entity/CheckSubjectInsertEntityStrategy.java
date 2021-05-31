package org.graduation.knowledge.service.strategy.impl.entity;

import org.graduation.knowledge.mapper.neo4j.Check3dMapper;
import org.graduation.knowledge.mapper.neo4j.CheckSubject3dMapper;
import org.graduation.knowledge.service.strategy.InsertEntityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("CheckSubjectInsertEntityStrategy")
public class CheckSubjectInsertEntityStrategy implements InsertEntityStrategy {

    final private CheckSubject3dMapper checkSubject3dMapper;
    final private Check3dMapper check3dMapper;

    @Autowired
    public CheckSubjectInsertEntityStrategy(CheckSubject3dMapper checkSubject3dMapper, Check3dMapper check3dMapper) {
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
        if (check3dMapper.isExits(entityName) >= 1) {
            return "Check";
        } else if (checkSubject3dMapper.isExits(entityName) >= 1) {
            return "CheckSubject";
        } else {
            checkSubject3dMapper.insertCheckSubject(entityName);
        }
        return "CheckSubject";
    }

}
