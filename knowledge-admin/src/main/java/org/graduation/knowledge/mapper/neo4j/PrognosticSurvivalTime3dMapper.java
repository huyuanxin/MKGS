package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("3D")
public interface PrognosticSurvivalTime3dMapper {

    /**
     * 初始化预后生存时间
     */
    void initPrognosticSurvivalTime();

    /**
     * 查询指定名字的预后生存时间的个数
     *
     * @param prognosticSurvivalTimeName 预后生存时间的名字
     * @return 个数
     */
    long isExits(@Param("prognosticSurvivalTimeName") String prognosticSurvivalTimeName);

    /**
     * 插入预后生存时间
     *
     * @param prognosticSurvivalTimeName 预后生存时间的名字
     */
    void insertPrognosticSurvivalTime(@Param("prognosticSurvivalTimeName") String prognosticSurvivalTimeName);
}
