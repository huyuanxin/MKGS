package org.graduation.knowledge.service;

import org.apache.ibatis.annotations.Param;
import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.model.Entity;
import org.graduation.knowledge.model.dto.GetRelationDTO;
import org.graduation.knowledge.model.dto.LoginDTO;
import org.graduation.knowledge.model.dto.LogoutDTO;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface AdminService {

    /**
     * 获得实体类型
     *
     * @return 实体类型列表
     */
    Result<List<String>> getEntityType();

    /**
     * 登录
     *
     * @param loginDTO 前端传入的登录体
     * @return 登录是否成功的返回体
     */
    Result<String> login(LoginDTO loginDTO);

    /**
     * 登出
     *
     * @param logoutDTO 前端传入的登出体
     * @return 登处是否成功的返回体
     */
    Result<String> logout(LogoutDTO logoutDTO);

    /**
     * 通过实体名获得实体的关系
     *
     * @param entityName 实体名
     * @return 实体的关系
     */
    Result<List<Entity>> getRelationTypeByName(String entityName);

    /**
     * 获得关系类型
     *
     * @return 关系类型列表
     */
    Result<List<String>> getRelationType();

    /**
     * 通过label类型获得该类型的全部数据
     *
     * @param entityType entities的类型
     * @return 该类型的全部entities
     */
    Result<List<Entity>> getAllEntitiesByType(@Param("entityType") String entityType);

    /**
     * 获得两个实体之间的存在的关系
     *
     * @param getRelationDTO 前端的输入
     * @return 两个实体之间的存在的关系
     */
    Result<List<String>> getRelationsBetweenTwoEntities(GetRelationDTO getRelationDTO);

}
