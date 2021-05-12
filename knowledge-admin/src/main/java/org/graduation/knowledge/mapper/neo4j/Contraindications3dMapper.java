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
public interface Contraindications3dMapper {
    /**
     * 初始化Contraindications,设置Contraindications的name为唯一值
     */
    void initContraindications();

    /**
     * 插入禁忌证
     *
     * @param contraindicationsName 禁忌证名称
     */
    void insertContraindications(@Param("contraindicationsName") String contraindicationsName);

    /**
     * 返回特点名称禁忌证的数量,作为是否存在的判断
     *
     * @param contraindicationsName 禁忌证名称
     * @return 存在的数量
     */
    long isExits(@Param("contraindicationsName") String contraindicationsName);
}
