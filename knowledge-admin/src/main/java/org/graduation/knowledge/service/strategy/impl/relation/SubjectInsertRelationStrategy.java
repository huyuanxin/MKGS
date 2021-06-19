package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DrugRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("subjectInsertRelationStrategy")
public class SubjectInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DRUG = "Drug";
    public static final String SUBJECT = "Subject";
    final private DrugRelation3dMapper drugRelation3dMapper;

    @Autowired
    public SubjectInsertRelationStrategy(DrugRelation3dMapper drugRelation3dMapper) {
        this.drugRelation3dMapper = drugRelation3dMapper;
    }

    /**
     * 插入关系
     *
     * @param headName 头节点的名称
     * @param tailName 尾节点的名称
     * @param headType 头节点的类型
     * @param tailType 尾节点的类型
     * @return 是否成功
     */
    @Override
    public Boolean insertRelation(String headName, String tailName, String headType, String tailType) {
        if (DRUG.equals(headType) && SUBJECT.equals(tailType)) {
            drugRelation3dMapper.insertRelSubjectDTS(headName, tailName);
            return true;
        }
        return false;
    }

}
