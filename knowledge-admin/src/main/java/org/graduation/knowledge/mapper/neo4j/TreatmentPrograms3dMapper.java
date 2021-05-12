package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 治疗方案
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface TreatmentPrograms3dMapper {

    /**
     * 初始化TreatmentPrograms,设置TreatmentPrograms的name为唯一值
     */
    void initTreatmentPrograms();

    /**
     * 插入治疗方案
     *
     * @param treatmentProgramsName 治疗方案名称
     */
    void insertTreatmentPrograms(@Param("treatmentProgramsName") String treatmentProgramsName);

    /**
     * 返回特定名称治疗方案的数量,作为是否存在的判断
     *
     * @param treatmentProgramsName 治疗方案名称
     * @return 存在的数量
     */
    long isExits(@Param("treatmentProgramsName") String treatmentProgramsName);
}
