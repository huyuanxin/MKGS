package org.graduation.knowledge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.model.Entity;
import org.graduation.knowledge.model.dto.GetRelationDTO;
import org.graduation.knowledge.model.dto.ImportDataDTO;
import org.graduation.knowledge.model.dto.LoginDTO;
import org.graduation.knowledge.model.dto.LogoutDTO;
import org.graduation.knowledge.service.AdminService;
import org.graduation.knowledge.service.ImportEntityService;
import org.graduation.knowledge.service.ImportRelationService;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author huyuanxin
 */
@Api(tags = "管理接口")
@RestController
@RequestMapping("/admin")
public class AdminController {

    final private AdminService adminService;
    final private ImportRelationService importRelationService;
    final private ImportEntityService importEntityService;

    @Autowired
    public AdminController(AdminService adminService, ImportRelationService importRelationService, ImportEntityService importEntityService) {
        this.adminService = adminService;
        this.importRelationService = importRelationService;
        this.importEntityService = importEntityService;
    }

    /**
     * 获得实体类型
     *
     * @return 实体类型列表
     */
    @GetMapping("/getEntityType")
    @ApiOperation(tags = "管理接口", value = "获得实体类型", response = Result.class)
    public Result<List<String>> getEntityType() {
        return adminService.getEntityType();
    }

    /**
     * 保存关系
     *
     * @param importDataDTO 输入
     * @return 保存信息
     */
    @PostMapping("/save")
    @ApiOperation(tags = "管理接口", value = "保存关系", response = Result.class)
    public Result<String> saveRelation(@RequestBody ImportDataDTO importDataDTO) {
        HashMap<String, String> map = importDataDtoToHashMap(importDataDTO);
        try {
            importEntityService.importEntity(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            importRelationService.insertRelations(importDataDTO, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success("导入成功");
    }

    /**
     * 登录
     *
     * @param loginDTO 前端传入的登录体
     */
    @PostMapping("/login")
    @ApiOperation(tags = "管理接口", value = "登录", response = Result.class)
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        return adminService.login(loginDTO);
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    @ApiOperation(tags = "管理接口", value = "登出", response = Result.class)
    public Result<String> logout(@RequestBody LogoutDTO logoutDTO) {
        return adminService.logout(logoutDTO);
    }

    private HashMap<String, String> importDataDtoToHashMap(ImportDataDTO importDataDTO) {
        HashMap<String, String> map = new HashMap<>(32);
        importDataDTO.getEntities().forEach(it -> map.put(it.getEntityName(), it.getEntityType()));
        return map;
    }

    /**
     * 关系实体类型
     *
     * @return 关系类型列表
     */
    @GetMapping("/getRelationType")
    @ApiOperation(tags = "管理接口", value = "获得关系类型", response = Result.class)
    public Result<List<String>> getRelationType() {
        return adminService.getRelationType();
    }

    /**
     * 通过实体名获得实体的关系
     *
     * @param entityName 实体名
     * @return 实体的关系
     */
    @GetMapping("/getAllRelationByName/{entityName}")
    @ApiOperation(tags = "管理接口", value = "获得实体对应的关系", response = Result.class)
    public Result<List<Entity>> getAllRelationByName(@PathVariable(value = "entityName") String entityName) {
        return adminService.getRelationTypeByName(entityName);
    }

    /**
     * 通过label类型获得该类型的全部数据
     *
     * @param entityType entities的类型
     * @return 该类型的全部entities
     */
    @GetMapping("/getAllEntitiesByType/{entityType}")
    @ApiOperation(tags = "管理接口", value = "获得entityType类型的全部数据", response = Result.class)
    public Result<List<Entity>> getAllEntitiesByType(@PathVariable("entityType") String entityType) {
        return adminService.getAllEntitiesByType(entityType);
    }

    /**
     * 获得两个实体之间的存在的关系
     *
     * @param getRelationDTO 前端的输入
     * @return 两个实体之间的存在的关系
     */
    @PostMapping("/getRelationsBetweenTwoEntities")
    @ApiOperation(tags = "管理接口", value = "获得entityType类型的全部数据", response = Result.class)
    public Result<List<String>> getRelationsBetweenTwoEntities(@RequestBody GetRelationDTO getRelationDTO) {
        return adminService.getRelationsBetweenTwoEntities(getRelationDTO);
    }

}
