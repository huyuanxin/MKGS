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
public interface Diagnosis3dMapper {

    /**
     * 初始化鉴别诊断
     */
    void initDiagnosis();

    /**
     * 查询指定名字的鉴别诊断的个数
     *
     * @param diagnosisName 鉴别诊断的名字
     * @return 个数
     */
    long isExits(@Param("diagnosisName") String diagnosisName);

    /**
     * 插入鉴别诊断
     *
     * @param diagnosisName 鉴别诊断的名字
     */
    void insertDiagnosis(@Param("diagnosisName") String diagnosisName);
}
