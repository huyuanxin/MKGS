package org.graduation.knowledge.service.strategy;

/**
 * 插入实体的策略模式接口
 *
 * @author huyuanxin
 */
public interface InsertStrategy {

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    String insertEntity(String entityName);

}
