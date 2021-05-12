package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface RelatedSymptom3dMapper {

    /**
     * 初始化相关症状
     */
    void initRelatedSymptom();

    /**
     * 查询指定名字的相关症状的个数
     *
     * @param relatedSymptomName 相关症状的名字
     * @return 个数
     */
    long isExits(@Param("relatedSymptomName") String relatedSymptomName);

    /**
     * 插入相关症状
     *
     * @param relatedSymptomName 相关症状的名字
     */
    void insertRelatedSymptom(@Param("relatedSymptomName") String relatedSymptomName);
}
