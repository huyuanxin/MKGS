package org.graduation.knowledge.service.strategy.impl.relation;

import org.graduation.knowledge.mapper.neo4j.DiseaseRelation3dMapper;
import org.graduation.knowledge.mapper.neo4j.SymptomRelation3dMapper;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("diseaseSiteInsertRelationStrategy")
public class DiseaseSiteInsertRelationStrategy implements InsertRelationStrategy {

    public final static String DISEASE = "Disease";
    public final static String DISEASE_SITE = "DiseaseSite";
    public final static String SYMPTOM = "Symptom";
    final private DiseaseRelation3dMapper diseaseRelation3dMapper;
    final private SymptomRelation3dMapper symptomRelation3dMapper;

    @Autowired
    public DiseaseSiteInsertRelationStrategy(DiseaseRelation3dMapper diseaseRelation3dMapper, SymptomRelation3dMapper symptomRelation3dMapper) {
        this.diseaseRelation3dMapper = diseaseRelation3dMapper;
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
        if (DISEASE.equals(headType) && DISEASE_SITE.equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseSiteDTP(headName, tailName);
            return true;
        } else if (DISEASE.equals(headType) && DISEASE.equals(tailType)) {
            diseaseRelation3dMapper.insertRelDiseaseSiteDTD(headName, tailName);
            return true;
        } else {
            if (DISEASE.equals(headType) && SYMPTOM.equals(tailType)) {
                diseaseRelation3dMapper.insertRelDiseaseSiteDTS(headName, tailName);
                return true;
            } else if (SYMPTOM.equals(headType) && DISEASE_SITE.equals(tailType)) {
                symptomRelation3dMapper.insertRelDiseaseSiteSTDS(headName, tailName);
                return true;
            } else if (SYMPTOM.equals(headType) && SYMPTOM.equals(tailType)) {
                symptomRelation3dMapper.insertRelDiseaseSiteSTS(headName, tailName);
                return true;
            } else if (SYMPTOM.equals(headType) && DISEASE.equals(tailType)) {
                symptomRelation3dMapper.insertRelDiseaseSiteSTD(headName, tailName);
                return true;
            }
        }
        return false;
    }

}
