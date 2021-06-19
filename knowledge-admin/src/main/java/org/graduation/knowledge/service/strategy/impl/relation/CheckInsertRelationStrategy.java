package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("checkInsertRelationStrategy")
public class CheckInsertRelationStrategy implements InsertRelationStrategy {

    final private SymptomRelation3dMapper symptomRelation3dMapper;
    public final static String SYMPTOM = "Symptom";
    public final static String CHECK = "Check";
    public final static String AUXILIARY_EXAMINATION = "AuxiliaryExamination";
    public final static String CHECK_SUBJECT = "CheckSubject";

    @Autowired
    public CheckInsertRelationStrategy(SymptomRelation3dMapper symptomRelation3dMapper) {
        this.symptomRelation3dMapper = symptomRelation3dMapper;
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
        if (SYMPTOM.equals(headType) && CHECK.equals(tailType)) {
            symptomRelation3dMapper.insertRelCheckSTC(headName, tailName);
            return true;
        } else {
            if (SYMPTOM.equals(headType) && AUXILIARY_EXAMINATION.equals(tailType)) {
                symptomRelation3dMapper.insertRelCheckSTA(headName, tailName);
                return true;
            } else {
                if (SYMPTOM.equals(headType) && CHECK_SUBJECT.equals(tailType)) {
                    symptomRelation3dMapper.insertRelCheckSTCS(headName, tailName);
                    return true;
                }
            }
        }
        return false;
    }

}
