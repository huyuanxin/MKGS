package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.mapper.neo4j.node.DiseaseNeo4jMapper;
import org.graduation.knowledge.model.node.*;
import org.graduation.knowledge.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyuanxin
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {

    final DiseaseNeo4jMapper diseaseNeo4jMapper;

    @Autowired
    public DiseaseServiceImpl(DiseaseNeo4jMapper diseaseNeo4jMapper) {
        this.diseaseNeo4jMapper = diseaseNeo4jMapper;
    }

    @Override
    public List<Symptom> getSymptomByDiseaseName(String name) {
        return diseaseNeo4jMapper.getSymptomByDiseaseName(name);
    }

    @Override
    public List<Disease> getAccompanyByDiseaseName(String name) {
        return diseaseNeo4jMapper.getAccompanyByDiseaseName(name);
    }

    @Override
    public List<Disease> getAccompanyReverseByDiseaseName(String name) {
        return diseaseNeo4jMapper.getAccompanyReverseByDiseaseName(name);
    }

    @Override
    public List<Food> getNotEatFoodByDiseaseName(String name) {
        return diseaseNeo4jMapper.getNotEatFoodByDiseaseName(name);
    }

    @Override
    public List<Food> getRecommendFoodByDiseaseName(String name) {
        return diseaseNeo4jMapper.getRecommendFoodByDiseaseName(name);
    }

    @Override
    public List<Food> getRecommendRecipeByDiseaseName(String name) {
        return diseaseNeo4jMapper.getRecommendRecipeByDiseaseName(name);
    }

    @Override
    public List<Drug> getCommonDrugByDiseaseName(String name) {
        return diseaseNeo4jMapper.getCommonDrugByDiseaseName(name);
    }

    @Override
    public List<Drug> getRecommendDrugByDiseaseName(String name) {
        return diseaseNeo4jMapper.getRecommendDrugByDiseaseName(name);
    }

    @Override
    public List<Check> getCheckByDiseaseName(String name) {
        return diseaseNeo4jMapper.getCheckByDiseaseName(name);
    }

    @Override
    public Disease getDiseaseByDiseaseName(String diseaseName) {
        return diseaseNeo4jMapper.getDiseaseByDiseaseName(diseaseName);
    }
}
