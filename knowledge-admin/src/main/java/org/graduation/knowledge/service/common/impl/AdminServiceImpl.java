package org.graduation.knowledge.service.common.impl;

import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.mapper.neo4j.AdminMapper;
import org.graduation.knowledge.model.Entity;
import org.graduation.knowledge.model.dto.LoginDTO;
import org.graduation.knowledge.model.dto.LogoutDTO;
import org.graduation.knowledge.service.common.AdminService;
import org.graduation.knowledge.util.RelationUtil;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huyuanxin
 */
@Service("InformationServiceImpl")
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    private static List<String> relationList = null;
    private static List<String> entityTypeList = null;
    private static final ConcurrentHashMap<String, List<Entity>> ENTITY_LIST_MAP = new ConcurrentHashMap<>(64);

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
        relationList = this.adminMapper.getAllRelations();
        entityTypeList = this.adminMapper.getAllEntitiesType();
        entityTypeList.forEach(it -> ENTITY_LIST_MAP.put(it, new ArrayList<>()));
    }

    /**
     * 获得实体类型
     *
     * @return 实体类型列表
     */
    @Override
    public Result<List<String>> getEntityType() {
        return ResultUtil.success(getEntityTypeHandler());
    }

    private List<String> getEntityTypeHandler() {
        return Optional.ofNullable(entityTypeList)
                .orElseGet(() -> {
                    entityTypeList = adminMapper.getAllEntitiesType();
                    return relationList;
                });
    }

    /**
     * 登录
     *
     * @param loginDTO 前端传入的登录体
     * @return 登录是否成功的返回体
     */
    @Override
    public Result<String> login(LoginDTO loginDTO) {
        // TODO: 登录逻辑

        return ResultUtil.success("登陆成功");
    }

    /**
     * 登出
     *
     * @return 登处是否成功的返回体
     */
    @Override
    public Result<String> logout(LogoutDTO logoutDTO) {
        // TODO: 登出逻辑

        return ResultUtil.success("登出成功");
    }

    /**
     * 通过实体名获得实体的关系
     *
     * @param entityName 实体名
     * @return 实体的关系
     */
    @Override
    public Result<List<Entity>> getRelationTypeByName(String entityName) {
        return Optional.ofNullable(adminMapper.getAllRelationByName(entityName))
                .filter(list -> list.size() > 0)
                .map(list -> {
                    list.forEach(it -> RelationUtil.getInstance().neo4jEntityTypeUnwrap(it));
                    return ResultUtil.success(list);
                })
                .orElse(ResultUtil.notFound());
    }

    /**
     * 获得关系类型
     *
     * @return 关系类型列表
     */
    @Override
    public Result<List<String>> getRelationType() {
        return ResultUtil.success(getRelationTypeHandler());
    }

    private List<String> getRelationTypeHandler() {
        return Optional.ofNullable(relationList)
                .orElseGet(() -> {
                    relationList = adminMapper.getAllRelations();
                    return relationList;
                });
    }

    /**
     * 通过label类型获得该类型的全部数据
     *
     * @param entityType entities的类型
     * @return 该类型的全部entities
     */
    @Override
    public Result<List<Entity>> getAllEntitiesByType(String entityType) {
        return Optional.ofNullable(ENTITY_LIST_MAP.get(entityType))
                .filter(it -> it.size() > 0)
                .map(ResultUtil::success)
                .orElseGet(() -> {
                    List<Entity> list = adminMapper.getAllEntitiesByType(entityType);
                    list.forEach(it -> RelationUtil.getInstance().neo4jEntityTypeUnwrap(it));
                    ENTITY_LIST_MAP.put(entityType, list);
                    return ResultUtil.success(list);
                });
    }

    /**
     * 更新数据
     */
    @Override
    public void updateData() {
        List<String> relationTypeList = getEntityTypeHandler();
        relationTypeList.forEach(it -> ENTITY_LIST_MAP.put(it, adminMapper.getAllEntitiesByType(it)));
    }

}
