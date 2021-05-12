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
public interface DiseaseSite3dMapper {

    /**
     * 初始化发病部位
     */
    void initDiseaseSite();

    /**
     * 查询指定名字的发病部位的个数
     *
     * @param diseaseSiteName 发病部位的名字
     * @return 个数
     */
    long isExits(@Param("diseaseSiteName") String diseaseSiteName);

    /**
     * 插入发病部位
     *
     * @param diseaseSiteName 发病部位的名字
     */
    void insertDiseaseSite(@Param("diseaseSiteName") String diseaseSiteName);
}
