package org.graduation.knowledge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.model.BodyParts;
import org.graduation.knowledge.service.BodyService;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author huyuanxin
 */
@Api(tags = "身体接口")
@RestController
@RequestMapping("/3D")
public class BodyController {

    private final BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService) {
        this.bodyService = bodyService;
    }

    /**
     * 通过大概的身体部位获得详细的身体部位
     *
     * @param bodyPart 大概的身体部位
     * @return 详细的身体部位
     */
    @GetMapping("/getDetailBody/{bodyPart}")
    @ApiOperation(tags = "身体接口", value = "通过大概的身体部位获得详细的身体部位", response = Result.class)
    public Result<List<String>> getDetailBody(@ApiParam(value = "大概的身体部位", required = true) @PathVariable("bodyPart") BodyParts bodyPart) {
        return bodyService.getDetailBody(bodyPart);
    }

    /**
     * 通过详细的身体部位获得对应部位的症状
     *
     * @param detailBodyPart 详细的身体部位
     * @return 身体部位对应的症状
     */
    @GetMapping("/getBodySymptom/{detailBodyPart}")
    @ApiOperation(tags = "身体接口", value = "过详细的身体部位获得对应部位的症状", response = Result.class, httpMethod = "GET")
    public Result<List<String>> getBodySymptom(@ApiParam(value = "详细的身体部位", required = true) @PathVariable("detailBodyPart") String detailBodyPart) {
        return bodyService.getSymptomNameListByDetailBodyPart(detailBodyPart);
    }

    /**
     * 获得uuid
     *
     * @return uuid
     */
    @GetMapping("/getUniversallyUniqueIdentifier")
    @ApiOperation(tags = "身体接口", value = "获得uuid", response = Result.class, httpMethod = "GET")
    public Result<String> getUniversallyUniqueIdentifier() {
        synchronized (this) {
            return ResultUtil.success(UUID.randomUUID().toString());
        }
    }

}
