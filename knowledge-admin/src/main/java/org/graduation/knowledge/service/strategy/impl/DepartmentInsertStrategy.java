package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Department3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("DepartmentInsertStrategy")
public class DepartmentInsertStrategy implements InsertStrategy {

    final private Department3dMapper department3dMapper;

    @Autowired
    public DepartmentInsertStrategy(Department3dMapper department3dMapper) {
        this.department3dMapper = department3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (department3dMapper.isExits(entityName) < 1) {
            department3dMapper.insertDepartment(entityName);
        }
        return "Department";
    }

}
