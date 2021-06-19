package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("pathogenesisInsertRelationStrategy")
public class PathogenesisInsertRelationStrategy implements InsertRelationStrategy {

    public static final String DISEASE = "Disease";
    public static final String PATHOGENESIS = "Pathogenesis";
    private final DiseaseRelation3dMapper diseaseRelation3dMapper;

    @Autowired
    public PathogenesisInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper) {
        this.diseaseRelation3dMapper = diseaseRelation3dMapper;
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
        if (DISEASE.equals(headType) && PATHOGENESIS.equals(tailType)) {
            diseaseRelation3dMapper.insertRelPathogenesisDTO(headName, tailName);
            return true;
        }
        return false;
    }

}
