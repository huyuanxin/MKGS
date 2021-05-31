package org.graduation.knowledge.service.common.impl;

import cn.hutool.extra.spring.SpringUtil;
import org.graduation.knowledge.mapper.neo4j.AdminMapper;
import org.graduation.knowledge.model.Relation;
import org.graduation.knowledge.model.dto.ImportDataDTO;
import org.graduation.knowledge.service.common.ImportRelationService;
import org.graduation.knowledge.service.strategy.InsertRelationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author huyuanxin
 */
@Service("ImportRelationService")
public class ImportRelationServiceImpl implements ImportRelationService {

    final private AdminMapper adminMapper;

    @Autowired
    public ImportRelationServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 插入关系
     *
     * @param importDataDTO 前端的保存的结果
     */
    @Override
    public void insertRelations(ImportDataDTO importDataDTO, HashMap<String, String> entities) {
        importDataDTO.getRelations().forEach(it -> insertRelationsHandler(it, entities));
    }

    private Boolean insertRelationsHandler(Relation relation, HashMap<String, String> entities) {
        String[] split = relation.getKey().split("-ignore")[0].split("&&");
        String headName = split[0];
        String tailName = split[1];
        String headType = entities.get(headName);
        String tailType = entities.get(tailName);
        String relationName = relation.getRelationName();
        return Optional.ofNullable(SpringUtil.getBean(relationName + "InsertRelationStrategy"))
                .filter(it -> it instanceof InsertRelationStrategy)
                .map(it -> {
                    Boolean flag = ((InsertRelationStrategy) it).insertRelation(headName, tailName, headType, tailType);
                    if (!flag) {
                        ((InsertRelationStrategy) it).insertRelation(headName, tailName, headType, tailType);
                    }
                    return true;
                }).orElseGet(() -> importNewRelation(headName, tailName, headType, tailType, relationName));
    }

    Boolean importNewRelation(String headName, String tailName, String headType, String tailType, String relationName) {
        if (adminMapper.countRelationsBetweenTwoEntities(headName, tailName, headType, tailType, relationName) < 1) {
            adminMapper.insertNewRelation(headName, tailName, headType, tailType, relationName);
            return true;
        }
        return false;
    }

}
