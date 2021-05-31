package org.graduation.knowledge.service.strategy;

/**
 * @author huyuanxin
 */
public interface InsertRelationStrategy {

    /**
     * 插入关系
     *
     * @param headName 头节点的名称
     * @param tailName 尾节点的名称
     * @param headType 头节点的类型
     * @param tailType 尾节点的类型
     * @return 是否成功
     */
    Boolean insertRelation(String headName, String tailName, String headType, String tailType);

}