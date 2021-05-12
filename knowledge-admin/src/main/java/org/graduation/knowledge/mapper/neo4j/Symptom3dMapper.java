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
public interface Symptom3dMapper {

    /**
     * 初始化Symptom,设置Symptom的name为唯一值
     */
    void initSymptom();

    /**
     * 插入疾病
     *
     * @param symptomName 症状名称
     */
    void insertSymptom(@Param("symptomName") String symptomName);

    /**
     * 返回特点名称疾病的数量,作为是否存在的判断
     *
     * @param symptomName 症状名称
     * @return 存在的数量
     */
    long isExits(@Param("symptomName") String symptomName);
}
