package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Department3dMapper {
    /**
     * 初始化所属科室
     */
    void initDepartment();

    /**
     * 查询指定名字的所属科室的个数
     *
     * @param departmentName 所属科室的名字
     * @return 个数
     */
    long isExits(@Param("departmentName") String departmentName);

    /**
     * 插入所属科室
     *
     * @param departmentName 所属科室的名字
     */
    void insertDepartment(@Param("departmentName") String departmentName);
}
