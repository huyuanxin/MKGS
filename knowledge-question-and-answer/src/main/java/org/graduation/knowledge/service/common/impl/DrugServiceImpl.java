package org.graduation.knowledge.service.common.impl;

import org.graduation.knowledge.mapper.neo4j.node.DrugNeo4jMapper;
import org.graduation.knowledge.model.node.Disease;
import org.graduation.knowledge.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyuanxin
 */
@Service
public class DrugServiceImpl implements DrugService {

    final DrugNeo4jMapper drugNeo4jMapper;

    @Autowired
    public DrugServiceImpl(DrugNeo4jMapper drugNeo4jMapper) {
        this.drugNeo4jMapper = drugNeo4jMapper;
    }

    @Override
    public List<Disease> getDiseaseByCommonDrug(String name) {
        return drugNeo4jMapper.getDiseaseByCommonDrug(name);
    }

    @Override
    public List<Disease> getDiseaseByRecommendDrug(String name) {
        return drugNeo4jMapper.getDiseaseByRecommendDrug(name);
    }

}
