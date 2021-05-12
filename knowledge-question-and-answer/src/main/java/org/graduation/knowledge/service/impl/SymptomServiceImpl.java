package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.mapper.neo4j.node.SymptomNeo4jMapper;
import org.graduation.knowledge.model.node.Disease;
import org.graduation.knowledge.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyuanxin
 */
@Service
public class SymptomServiceImpl implements SymptomService {

    final SymptomNeo4jMapper symptomNeo4jMapper;

    @Autowired
    public SymptomServiceImpl(SymptomNeo4jMapper symptomNeo4jMapper) {
        this.symptomNeo4jMapper = symptomNeo4jMapper;
    }

    @Override
    public List<Disease> getDiseaseBySymptom(String name) {
        return symptomNeo4jMapper.getDiseaseBySymptom(name);
    }

}
