package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.RelatedTo3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("RelatedToInsertStrategy")
public class RelatedToInsertStrategy implements InsertStrategy {

    final private RelatedTo3dMapper relatedTo3dMapper;

    @Autowired
    public RelatedToInsertStrategy(RelatedTo3dMapper relatedTo3dMapper) {
        this.relatedTo3dMapper = relatedTo3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (relatedTo3dMapper.isExits(entityName) < 1) {
            relatedTo3dMapper.insertRelatedTo(entityName);
        }
        return "RelatedTo";
    }

}
