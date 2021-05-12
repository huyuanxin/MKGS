package org.graduation.knowledge.mapper.diagnosis;

import org.graduation.knowledge.mapper.DiagnosisMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

/**
 * @author huyuanxin
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class DiagnosisMapperTest {

    @Autowired
    DiagnosisMapper diagnosisMapper;

    @Test
    void getDiseaseNameListByDiseaseSite() {
        diagnosisMapper.getDiseaseNameListByDiseaseSite("乳突").forEach(System.out::println);
    }

    @Test
    void getSymptomNameListByDiseaseName() {
        diagnosisMapper.getSymptomNameListByDiseaseName("18-三体综合征").forEach(System.out::println);
    }

    @Test
    void getDiseaseNameListBySymptom(){
        List<String> list= Arrays.asList("室间隔缺损","耳聋");
        diagnosisMapper.getDiseaseNameListBySymptomList(list)
                .forEach(System.out::println);
    }
}