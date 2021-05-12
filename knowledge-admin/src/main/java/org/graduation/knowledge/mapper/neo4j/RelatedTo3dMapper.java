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
public interface RelatedTo3dMapper {
    /**
     * 初始化相关导致
     */
    void initRelatedTo();

    /**
     * 查询指定名字的相关导致的个数
     *
     * @param relatedToName 相关导致的名字
     * @return 个数
     */
    long isExits(@Param("relatedToName") String relatedToName);

    /**
     * 插入相关导致
     *
     * @param relatedToName 相关导致的名字
     */
    void insertRelatedTo(@Param("relatedToName") String relatedToName);
}
