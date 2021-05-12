package org.graduation.knowledge.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
@DS("3D")
public interface DiagnosisMapper {

    /**
     * 查询指定部位可能发生的疾病
     *
     * @param diseaseSite 发病部位
     * @return 可能发生的疾病
     */
    List<String> getDiseaseNameListByDiseaseSite(@Param("diseaseSite") String diseaseSite);

    /**
     * 疾病的相关症状
     *
     * @param diseaseName 疾病名称
     * @return 症状名称
     */
    List<String> getSymptomNameListByDiseaseName(@Param("diseaseName") String diseaseName);

    /**
     * 通过一系列症状获得疾病列表
     *
     * @param symptomList 一些列症状
     * @return 疾病列表
     */
    List<String> getDiseaseNameListBySymptomList(@Param("symptomList") List<String> symptomList);

}
