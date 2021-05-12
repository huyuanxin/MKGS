package org.graduation.knowledge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.model.dto.DiagnosisDTO;
import org.graduation.knowledge.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huyuanxin
 */
@RestController
@Api(tags = "诊断接口")
@RequestMapping("/3D")
public class DiagnosisController {

    final private DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    /**
     * 整个诊断的接口
     *
     * @param diagnosisDTO 诊断输入
     * @return 结果
     */
    @PostMapping("/diagnosis")
    @ApiOperation(tags = "诊断接口", value = "诊断接口", response = Result.class)
    public Result<List<String>> diagnosis(@RequestBody DiagnosisDTO diagnosisDTO) {
        return diagnosisService.diagnosis(diagnosisDTO);
    }

}
