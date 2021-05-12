package org.graduation.knowledge.service.impl;

import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.mapper.DiagnosisMapper;
import org.graduation.knowledge.model.BodyParts;
import org.graduation.knowledge.model.DetailBodyParts;
import org.graduation.knowledge.service.BodyService;
import org.graduation.knowledge.util.ListUtil;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author huyuanxin
 */
@Service("BodyService")
public class BodyServiceImpl implements BodyService {

    final DiagnosisMapper diagnosisMapper;

    @Autowired
    public BodyServiceImpl(DiagnosisMapper diagnosisMapper) {
        this.diagnosisMapper = diagnosisMapper;
    }

    /**
     * 通过大概的身体部位获得详细的身体部位
     *
     * @param bodyPart 大概的身体部位
     * @return 详细的身体部位
     */
    @Override
    public Result<List<String>> getDetailBody(BodyParts bodyPart) {
        return getDetailBodyHelper(bodyPart);
    }

    /**
     * 通过大概的身体部位获得详细的身体部位，该函数是为了简化getDetailBody的实现
     *
     * @param bodyPart 大概的身体部位
     * @return 详细的身体部位
     */
    private static Result<List<String>> getDetailBodyHelper(BodyParts bodyPart) {
        // 头部、肩颈部、胸部、腹部、背部、臀部、双上肢、生殖器、双下肢
        // Head、ShoulderAndNeck、Chest、Abdomen、Back、Buttocks、UpperLimbs、Genitals、LowerLimbs
        switch (bodyPart) {
            case Head: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnHead());
            }
            case ShoulderAndNeck: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnShoulderAndNeck());
            }
            case Chest: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnChest());
            }
            case Abdomen: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnAbdomen());
            }
            case Back: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnBack());
            }
            case Buttocks: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnButtocks());
            }
            case UpperLimbs: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnUpperLimbs());
            }
            case Genitals: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnGenitals());
            }
            case LowerLimbs: {
                return ResultUtil.success(DetailBodyParts.INSTANCE.getDetailBodyOnLowerLimbs());
            }
            default: {
                return ResultUtil.notFound("没有查询到详细的身体部位");
            }
        }
    }

    /**
     * 获得详细的身体部位可能发生的症状
     *
     * @param detailBodyPart 详细的身体部位
     * @return 部位对应的症状
     */
    @Override
    public Result<List<String>> getSymptomNameListByDetailBodyPart(String detailBodyPart) {
        return Optional.ofNullable(diagnosisMapper.getDiseaseNameListByDiseaseSite(detailBodyPart))
                .map(it -> {
                    List<String> symptomNameList = new ArrayList<>();
                    it.forEach(diseaseName -> {
                        Optional<List<String>> symptomList = Optional.ofNullable(diagnosisMapper.getSymptomNameListByDiseaseName(diseaseName));
                        symptomList.map(symptomNameList::addAll);
                    });
                    return ResultUtil.success(ListUtil.deleteRepeat(symptomNameList));
                })
                .orElse(ResultUtil.notFound("没有查询到症状列表"));
    }

}
