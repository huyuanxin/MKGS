package org.graduation.knowledge.service.common.impl;

import org.graduation.knowledge.factory.AnswerFactory;
import org.graduation.knowledge.factory.QuestionTypeFactory;
import org.graduation.knowledge.mapper.neo4j.node.*;
import org.graduation.knowledge.service.QuestionService;
import org.graduation.knowledge.util.SolrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author huyuanxin
 */
@Service
@Configuration
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class QuestionServiceImpl implements QuestionService {

    final DepartmentNeo4jMapper departmentNeo4jMapper;
    final CheckNeo4jMapper checkNeo4jMapper;
    final DrugNeo4jMapper drugNeo4jMapper;
    final FoodNeo4jMapper foodNeo4jMapper;
    final ProducerNeo4jMapper producerNeo4jMapper;
    final SymptomNeo4jMapper symptomNeo4jMapper;
    final DiseaseNeo4jMapper diseaseNeo4jMapper;
    final AnswerFactory answerFactory;
    final QuestionTypeFactory questionTypeFactory;


    /**
     * 存储实体，例如:symptom,disease,producer
     */
    Set<String> allEntity = new HashSet<>();

    /**
     * 存储用户输入的实体，封装问题类型时可以去掉这些实体
     */
    Set<String> allEntityQuestion = new HashSet<>();

    @Autowired
    public QuestionServiceImpl(DepartmentNeo4jMapper departmentNeo4jMapper, CheckNeo4jMapper checkNeo4jMapper, DrugNeo4jMapper drugNeo4jMapper, FoodNeo4jMapper foodNeo4jMapper, ProducerNeo4jMapper producerNeo4jMapper, SymptomNeo4jMapper symptomNeo4jMapper, DiseaseNeo4jMapper diseaseNeo4jMapper, AnswerFactory answerFactory, QuestionTypeFactory questionTypeFactory) {
        this.departmentNeo4jMapper = departmentNeo4jMapper;
        this.checkNeo4jMapper = checkNeo4jMapper;
        this.drugNeo4jMapper = drugNeo4jMapper;
        this.foodNeo4jMapper = foodNeo4jMapper;
        this.producerNeo4jMapper = producerNeo4jMapper;
        this.symptomNeo4jMapper = symptomNeo4jMapper;
        this.diseaseNeo4jMapper = diseaseNeo4jMapper;
        this.answerFactory = answerFactory;
        this.questionTypeFactory = questionTypeFactory;
    }

    @Override
    public String answer(String input) {
        String answer = questionParser(input);
        if (answer == null || "".equals(answer)) {
            return "请输入正确的问题（输入实体类）";
        }
        return answer;
    }

    @SuppressWarnings("unchecked")
    public String questionParser(String input) {
        //List<String> words = hanLPUtil.getWords(url, token, input, size);
        //List<String> words = solrUtil.analyse(input, "text_ik");
        List<String> words = SolrUtil.getWord(input);
        System.out.println(words);
        // 这个方法把分词的集合转为map格式
        // {args=[{name=感冒, entity=[disease]}, {name=肺炎, entity=[disease]}],
        // question_types=[disease_prevent, disease_cause]}
        Map<String, Object> resultMap = questionClassify(words);
        System.out.println(resultMap);
        StringBuilder answer = new StringBuilder();
        if (((List<Map<String, Object>>) resultMap.get("args")).isEmpty()) {
            System.out.println("实体为空");
            return null;
        }
        //[  {"name": "耳鸣","entity": ["disease", "symptom"]},{"name": "感冒","entity": ["disease"]},
        //    {"name": "美林", "entity": ["producer"]}  ]
        List<Map<String, Object>> argsList = (List<Map<String, Object>>) resultMap.get("args");

        //["disease_do_food","disease_drug"]
        Set<String> questionTypesList = (HashSet<String>) resultMap.get("question_types");
        for (Map<String, Object> map : argsList) {
            //entity = "耳鸣" , "美林"
            String entity = (String) map.get("name");
            for (String questionType : questionTypesList) {
                // 循环每一个问题分类，与所有实体进行排列组合
                answer.append(answerSearch(entity, questionType)).append("\n");
            }
        }
        return answer.toString();
    }

    public Map<String, Object> questionClassify(List<String> words) {

        Map<String, Object> resultMap = new HashMap<>();
        //封装问题实体
        List<Map<String, Object>> argsList = getArgsList(words);
        resultMap.put("args", argsList);
        //initQuestions();
        //封装问题类型
        Set<String> questionTypesList = getQuestionTypesList(words);
        resultMap.put("question_types", questionTypesList);
        return resultMap;
    }


    public String answerSearch(String entity, String questionType) {
        //简单工厂模式，根据不同entity，questionType返回不同answer
        return answerFactory.answerSearch(entity, questionType);
    }


    /**
     * 封装问题类型
     *
     * @param list list
     * @return questionTypesList
     */
    private Set<String> getQuestionTypesList(List<String> list) {
        //Set<String> questionTypesList = new HashSet<>();
        //把实体过滤掉
        list.removeAll(allEntityQuestion);
        //简单工厂模式，根据不同list返回不同questionTypesList
        return questionTypeFactory.getQuestionTypeList(list, allEntity);
    }

    //封装实体
    private List<Map<String, Object>> getArgsList(List<String> list) {
        List<Map<String, Object>> argsList = new ArrayList<>();
        //清空上一次的查询数据
        allEntity.clear();
        // 这里存在重复查询的问题
        for (String str : list) {
            Map<String, Object> map = new HashMap<>();
            //怕有重复数据，所以查询全部
            Long checks = checkNeo4jMapper.countByName(str);
            Long departments = departmentNeo4jMapper.countByName(str);
            Long diseases = diseaseNeo4jMapper.countByName(str);
            Long drugs = drugNeo4jMapper.countByName(str);
            Long foods = foodNeo4jMapper.countByName(str);
            Long producers = producerNeo4jMapper.countByName(str);
            Long symptoms = symptomNeo4jMapper.countByName(str);
            List<String> entity = new ArrayList<>();
            if (checks == 1L) {
                entity.add("check");
            }
            if (departments == 1L) {
                entity.add("department");
            }
            if (diseases == 1L) {
                entity.add("disease");
            }
            if (drugs == 1L) {
                entity.add("drug");
            }
            if (foods == 1L) {
                entity.add("food");
            }
            if (producers == 1L) {
                entity.add("producer");
            }
            if (symptoms == 1L) {
                entity.add("symptom");
            }
            if (!entity.isEmpty()) {
                //存储用户输入的实体，封装问题类型时可以去掉这些实体
                allEntityQuestion.add(str);
                //存储实体，例如:symptom,disease,producer
                allEntity.addAll(entity);
                map.put("name", str);
                map.put("entity", entity);
                argsList.add(map);
            }
        }
        return argsList;
    }

}
