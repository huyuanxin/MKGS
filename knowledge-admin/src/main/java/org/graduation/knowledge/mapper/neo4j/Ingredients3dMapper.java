package org.graduation.knowledge.mapper.neo4j;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 药物-成份
 *
 * @author ztt
 * @author huyuanxin
 */
@Mapper
@DS("3D")
@Repository
public interface Ingredients3dMapper {

    /**
     * 初始化Ingredients,设置Ingredients的name为唯一值
     */
    void initIngredients();

    /**
     * 插入成份
     *
     * @param ingredientsName 成份名称
     */
    void insertIngredients(@Param("ingredientsName") String ingredientsName);

    /**
     * 返回特定名称成份的数量,作为是否存在的判断
     *
     * @param ingredientsName 成份名称
     * @return 存在的数量
     */
    long isExits(@Param("ingredientsName") String ingredientsName);
}
