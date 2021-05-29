package org.graduation.knowledge.service.common.impl;

import org.graduation.knowledge.mapper.neo4j.node.CheckNeo4jMapper;
import org.graduation.knowledge.model.node.Disease;
import org.graduation.knowledge.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huyuanxin
 */
@Service
public class CheckServiceImpl implements CheckService {

    final CheckNeo4jMapper checkNeo4jMapper;

    @Autowired
    public CheckServiceImpl(CheckNeo4jMapper checkNeo4jMapper) {
        this.checkNeo4jMapper = checkNeo4jMapper;
    }

    @Override
    public List<Disease> getDiseaseByCheckName(String name) {
        return checkNeo4jMapper.getDiseaseByCheckName(name);
    }

}
