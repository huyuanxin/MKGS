package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.mapper.neo4j.AdminMapper;
import org.graduation.knowledge.model.Entity;
import org.graduation.knowledge.model.dto.LoginDTO;
import org.graduation.knowledge.model.dto.LogoutDTO;
import org.graduation.knowledge.service.AdminService;
import org.graduation.knowledge.util.RelationUtil;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author huyuanxin
 */
@Service("InformationServiceImpl")
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    private static List<String> relationList = null;
    private static List<String> entityTypeList = null;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 获得实体类型
     *
     * @return 实体类型列表
     */
    @Override
    public Result<List<String>> getEntityType() {
        return Optional.ofNullable(entityTypeList)
                .map(ResultUtil::success)
                .orElseGet(()->{
                    entityTypeList=adminMapper.getAllEntitiesType();
                    return ResultUtil.success(entityTypeList);
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
        return Optional.ofNullable(relationList)
                .map(ResultUtil::success)
                .orElseGet(()->{
                    relationList=adminMapper.getAllRelations();
                    return ResultUtil.success(relationList);
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
        List<Entity> entityList = adminMapper.getAllEntitiesByType(entityType);
        entityList.forEach(it -> RelationUtil.getInstance().neo4jEntityTypeUnwrap(it));
        return ResultUtil.success(entityList);
    }

}
