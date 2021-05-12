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
public interface Check3dMapper {
    /**
     * 初始化检查
     */
    void initCheck();

    /**
     * 查询指定名字的检查的个数
     *
     * @param checkName 检查的名字
     * @return 个数
     */
    long isExits(@Param("checkName") String checkName);

    /**
     * 插入检查
     *
     * @param checkName 检查的名字
     */
    void insertCheck(@Param("checkName") String checkName);
}
