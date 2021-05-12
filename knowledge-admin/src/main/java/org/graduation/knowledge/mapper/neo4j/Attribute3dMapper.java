package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Attribute3dMapper {

    /**
     * 初始化Attribute,设置Attribute的name为唯一值
     */
    void initAttribute();

    /**
     * 插入属性
     *
     * @param attributeName 属性名称
     */
    void insertAttribute(@Param("attributeName") String attributeName);

    /**
     * 返回特定名称属性的数量,作为是否存在的判断
     *
     * @param attributeName 属性名称
     * @return 存在的数量
     */
    long isExits(@Param("attributeName") String attributeName);
}

