package org.graduation.knowledge.service;

import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.model.BodyParts;

import java.util.List;

/**
 * @author huyuanxin
 */
public interface BodyService {

    /**
     * 通过大概的身体部位获得详细的身体部位
     *
     * @param bodyPart 大概的身体部位
     * @return 详细的身体部位
     */
    Result<List<String>> getDetailBody(BodyParts bodyPart);

    /**
     * 获得详细的身体部位可能发生的症状
     *
     * @param detailBodyPart 详细的身体部位
     * @return 部位对应的症状
     */
    Result<List<String>> getSymptomNameListByDetailBodyPart(String detailBodyPart);
}
