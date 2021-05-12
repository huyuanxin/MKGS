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
public interface Prognosis3dMapper {

    /**
     * 初始化Prognosis,设置Prognosis的name为唯一值
     */
    void initPrognosis();

    /**
     * 插入预后状况
     *
     * @param prognosisName 预后状况名称
     */
    void insertPrognosis(@Param("prognosisName") String prognosisName);

    /**
     * 返回特定名称预后状况的数量,作为是否存在的判断
     *
     * @param prognosisName 预后状况名称
     * @return 存在的数量
     */
    long isExits(@Param("prognosisName") String prognosisName);
}
