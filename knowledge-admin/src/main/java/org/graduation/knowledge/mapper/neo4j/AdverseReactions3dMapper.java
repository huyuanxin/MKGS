package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 药物-不良反应
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface AdverseReactions3dMapper {

    /**
     * 初始化AdverseReactions,设置AdverseReactions的name为唯一值
     */
    void initAdverseReactions();

    /**
     * 插入AdverseReactions
     *
     * @param adverseReactionsName 不良反应名称
     */
    void insertAdverseReactions(@Param("adverseReactionsName") String adverseReactionsName);

    /**
     * 返回特定名称不良反应的数量,作为是否存在的判断
     *
     * @param adverseReactionsName 不良反应名称
     * @return 存在的数量
     */

    long isExits(@Param("adverseReactionsName") String adverseReactionsName);
}

