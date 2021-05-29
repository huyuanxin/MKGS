package org.graduation.knowledge.service.common.impl;

import cn.hutool.http.HttpStatus;
import org.graduation.knowledge.base.Result;
import org.graduation.knowledge.mapper.DiagnosisMapper;
import org.graduation.knowledge.model.Args;
import org.graduation.knowledge.model.dto.DiagnosisDTO;
import org.graduation.knowledge.service.DiagnosisService;
import org.graduation.knowledge.util.ListUtil;
import org.graduation.knowledge.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huyuanxin
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private static final LinkedHashMap<String, List<DiagnosisDTO>> REQUEST_MAP = new LinkedHashMap<>(128);
    private final static Integer MAX_SIZE = 1024;
    private final DiagnosisMapper diagnosisMapper;
    private final static Integer MAX_RETURN_SIZE = 1;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisMapper diagnosisMapper) {
        this.diagnosisMapper = diagnosisMapper;
    }

    /**
     * 整个诊断的接口
     *
     * @param diagnosisDTO 诊断输入
     * @return 结果
     */
    @Override
    public Result<List<String>> diagnosis(DiagnosisDTO diagnosisDTO) {
        String uuid = diagnosisDTO.getUuid();
        if (updateRequestMap(uuid, diagnosisDTO)) {
            if (Args.Symptom.equals(diagnosisDTO.getArgs())) {
                return symptomArgsHandler(uuid);
            } else if (Args.Age.equals(diagnosisDTO.getArgs())) {
                return ageArgsHandler(uuid);
            } else {
                return ResultUtil.error(HttpStatus.HTTP_BAD_REQUEST, "无效的请求");
            }
        }
        cleanFinish(uuid);
        return ResultUtil.notFound("失败");
    }

    private Result<List<String>> symptomArgsHandler(String uuid) {
        List<String> symptomList = getArgsListByUuid(uuid, Args.Symptom);
        List<String> diseaseNameList = diagnosisMapper.getDiseaseNameListBySymptomList(symptomList);
        return Optional.ofNullable(diseaseNameList)
                .filter(it -> it.size() > MAX_RETURN_SIZE)
                .map(list -> {
                    List<String> response = new ArrayList<>();
                    list.forEach(it -> response.addAll(diagnosisMapper.getSymptomNameListByDiseaseName(it)));
                    response.removeAll(symptomList);
                    return ResultUtil.accept(ListUtil.deleteRepeat(response));
                })
                .orElseGet(() -> {
                    cleanFinish(uuid);
                    return ResultUtil.success(diseaseNameList);
                });
    }

    private Result<List<String>> ageArgsHandler(String uuid) {
        List<String> ageList = getArgsListByUuid(uuid, Args.Age);
        // TODO: 拿到疾病列表

        // TODO: 判断疾病数量

        // TODO: 大于3继续，返回继续的httpStatus，小于则返回疾病结果
        return ResultUtil.notFound("失败");
    }

    /**
     * 通过uuid拿到全部的症状
     *
     * @param uuid uuid
     * @return 全部的症状
     */
    List<String> getArgsListByUuid(String uuid, Args args) {
        return Optional.ofNullable(REQUEST_MAP.get(uuid))
                .map(list -> list.stream().filter(it -> args.equals(it.getArgs()) && uuid.equals(it.getUuid())).collect(Collectors.toList()))
                .map(list -> {
                    List<String> symptomList = new ArrayList<>();
                    list.forEach(it -> symptomList.add(it.getValues()));
                    return symptomList;
                })
                .orElse(new ArrayList<>());
    }

    public Boolean updateRequestMap(String uuid, DiagnosisDTO diagnosisDTO) {
        return Optional.ofNullable(REQUEST_MAP.get(uuid))
                .map(it -> {
                    it.add(diagnosisDTO);
                    synchronized (this) {
                        REQUEST_MAP.put(uuid, it);
                        return true;
                    }
                })
                .orElseGet(() -> createNewListToMap(uuid, diagnosisDTO));
    }

    public Boolean createNewListToMap(String uuid, DiagnosisDTO diagnosisDTO) {
        List<DiagnosisDTO> diagnosisDTOList = new ArrayList<>();
        diagnosisDTOList.add(diagnosisDTO);
        synchronized (this) {
            REQUEST_MAP.put(uuid, diagnosisDTOList);
            return true;
        }
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void cleanUp() {
        synchronized (this) {
            while (REQUEST_MAP.size() > MAX_SIZE) {
                Iterator<Map.Entry<String, List<DiagnosisDTO>>> iterator = REQUEST_MAP.entrySet().iterator();
                if (iterator.hasNext()) {
                    REQUEST_MAP.remove(iterator.next().getKey());
                }
            }
        }
    }

    public void cleanFinish(String uuid) {
        synchronized (this) {
            REQUEST_MAP.remove(uuid);
        }
    }

}
