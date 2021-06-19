package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.TreatmentRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("checkSubject")
public class CheckSubjectInsertRelationStrategy implements InsertRelationStrategy {

    public static final String TREATMENT = "Treatment";
    public static final String CHECK_SUBJECT = "CheckSubject";
    public static final String CHECK = "Check";
    final private TreatmentRelation3dMapper treatmentRelation3dMapper;

    @Autowired
    public CheckSubjectInsertRelationStrategy(TreatmentRelation3dMapper treatmentRelation3dMapper) {
        this.treatmentRelation3dMapper = treatmentRelation3dMapper;
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
        if (TREATMENT.equals(headType) && CHECK_SUBJECT.equals(tailType)) {
            treatmentRelation3dMapper.insertRelCheckSubjectTTCS(headName, tailName);
            return true;
        } else if (TREATMENT.equals(headType) && CHECK.equals(tailType)) {
            treatmentRelation3dMapper.insertRelCheckSubjectTTC(headName, tailName);
            return true;
        }
        return false;
    }

}
