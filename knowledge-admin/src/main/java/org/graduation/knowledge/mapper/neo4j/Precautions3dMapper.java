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
public interface Precautions3dMapper {
    /**
     * 初始化Precautions,设置Precautions的name为唯一值
     */
    void initPrecautions();

    /**
     * 插入注意事项
     *
     * @param precautionsName 名称
     */
    void insertPrecautions(@Param("precautionsName") String precautionsName);

    /**
     * 返回特点名称注意事项的数量,作为是否存在的判断
     *
     * @param precautionsName 注意事项名称
     * @return 存在的数量
     */
    long isExits(@Param("precautionsName") String precautionsName);
}
