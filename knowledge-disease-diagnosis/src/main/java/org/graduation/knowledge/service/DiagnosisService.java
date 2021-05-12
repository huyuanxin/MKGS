package org.graduation.knowledge.service;

import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.model.dto.DiagnosisDTO;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface DiagnosisService {

    /**
     * 整个诊断的接口
     *
     * @param diagnosisDTO 诊断输入
     * @return 结果
     */
    Result<List<String>> diagnosis(DiagnosisDTO diagnosisDTO);

}
