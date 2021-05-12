package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 症状-辅助检查
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface AuxiliaryExamination3dMapper {

    /**
     * 初始化AuxiliaryExamination,设置AuxiliaryExamination的name为唯一值
     */
    void initAuxiliaryExamination();

    /**
     * 插入辅助检查
     *
     * @param auxiliaryExaminationName 辅助检查名称
     */
    void insertAuxiliaryExamination(@Param("auxiliaryExaminationName") String auxiliaryExaminationName);

    /**
     * 返回特定名称辅助检查的数量,作为是否存在的判断
     *
     * @param auxiliaryExaminationName 辅助检查名称
     * @return 存在的数量
     */
    long isExits(@Param("auxiliaryExaminationName") String auxiliaryExaminationName);
}