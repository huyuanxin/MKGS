package org.graduation.knowledge.factory;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huyuanxin
 */
@Component
public class QuestionTypeFactory {


    // 初始化问句疑问词

    private List<String> symptom_qwds = Arrays.asList("症状", "表征", "现象", "症候", "表现");
    private List<String> cause_qwds = Arrays.asList("原因", "成因", "为什么", "怎么会", "怎样才", "咋样才", "怎样会", "如何会", "为啥", "为何", "如何才会", "怎么才会", "会导致", "会造成");
    private List<String> acompany_qwds = Arrays.asList("并发症", "并发", "一起发生", "一并发生", "一起出现", "一并出现", "一同发生", "一同出现", "伴随发生", "伴随", "共现");
    private List<String> food_qwds = Arrays.asList("饮食", "饮用", "吃", "食", "伙食", "膳食", "喝", "菜", "忌口", "补品", "保健品", "食谱", "菜谱", "食用", "食物", "补品");
    private List<String> drug_qwds = Arrays.asList("药", "药品", "用药", "胶囊", "口服液", "炎片");
    private List<String> prevent_qwds = Arrays.asList("预防", "防范", "抵制", "抵御", "防止", "躲避", "逃避", "避开", "免得", "逃开", "避开", "避掉", "躲开", "躲掉", "绕开",
            "怎样才能不", "怎么才能不", "咋样才能不", "咋才能不", "如何才能不",
            "怎样才不", "怎么才不", "咋样才不", "咋才不", "如何才不",
            "怎样才可以不", "怎么才可以不", "咋样才可以不", "咋才可以不", "如何可以不",
            "怎样才可不", "怎么才可不", "咋样才可不", "咋才可不", "如何可不");
    private List<String> lasttime_qwds = Arrays.asList("周期", "多久", "多长时间", "多少时间", "几天", "几年", "多少天", "多少小时", "几个小时", "多少年");
    private List<String> cureway_qwds = Arrays.asList("怎么治疗", "如何医治", "怎么医治", "怎么治", "怎么医", "如何治", "医治方式", "疗法", "咋治", "怎么办", "咋办", "咋治");
    private List<String> cureprob_qwds = Arrays.asList("多大概率能治好", "多大几率能治好", "治好希望大么", "几率", "几成", "比例", "可能性", "能治", "可治", "可以治", "可以医", "治", "治好", "治疗");
    private List<String> easyget_qwds = Arrays.asList("易感人群", "容易感染", "易发人群", "什么人", "哪些人", "感染", "染上", "得上");
    private List<String> check_qwds = Arrays.asList("检查", "检查项目", "查出", "检查", "测出", "试出", "查");
    private List<String> belong_qwds = Arrays.asList("属于什么科", "属于", "什么科", "科室");
    private List<String> cure_qwds = Arrays.asList("治疗什么", "治啥", "治疗啥", "医治啥", "治愈啥", "主治啥", "主治什么", "有什么用", "有何用", "用处", "用途",
            "有什么好处", "有什么益处", "有何益处", "用来", "用来做啥", "用来作甚", "需要", "要", "好处", "益处", "什么用");
    private List<String> deny_words = Arrays.asList("否", "非", "不", "无", "弗", "勿", "毋", "未", "没", "莫", "没有", "防止", "不再",
            "不会", "不能", "忌", "禁止", "防止", "难以", "忘记", "忽视", "放弃", "拒绝", "杜绝", "不是", "并未",
            "并无", "仍未", "难以出现", "切勿", "不要", "不可", "别", "管住", "注意", "小心", "少");


    public Set<String> getQuestionTypeList(List<String> list, Set<String> allEntity) {
        Set<String> questionTypesList = new HashSet<>();
        for (String str : list) {
            //症状
            if (symptom_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_symptom");
            }
            if (symptom_qwds.contains(str) && allEntity.contains("symptom")) {
                questionTypesList.add("symptom_disease");
            }
            //# 原因
            if (cause_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_cause");
            }
            // # 并发症
            if (acompany_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_acompany");
            }
            //推荐食品
            if (food_qwds.contains(str) && allEntity.contains("disease")) {
                for (String s : list) {
                    if (deny_words.contains(s)) {
                        questionTypesList.add("disease_not_food");
                        break;
                    }
                }
                if (!questionTypesList.contains("disease_not_food")) {
                    //如果不包含否定词，那么就是肯定词
                    questionTypesList.add("disease_do_food");
                }
            }
            //已知食物找疾病
            if ((food_qwds.contains(str) || cure_qwds.contains(str)) && allEntity.contains("food")) {
                for (String s : list) {
                    if (deny_words.contains(s)) {
                        questionTypesList.add("food_not_disease");
                        break;
                    }
                }
                if (!questionTypesList.contains("food_not_disease")) {
                    //如果不包含否定词，那么就是肯定词
                    questionTypesList.add("food_do_disease");
                }
            }
            // # 推荐药品
            if (drug_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_drug");
            }
            // # 药品治啥病
            if (cure_qwds.contains(str) && allEntity.contains("drug")) {
                questionTypesList.add("drug_disease");
            }
            // # 疾病接受检查项目
            if (check_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_check");
            }
            // # 已知检查项目查相应疾病
            if ((check_qwds.contains(str) || cure_qwds.contains(str)) && allEntity.contains("drug")) {
                questionTypesList.add("check_disease");
            }
            // # 症状防御
            if (prevent_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_prevent");
            }
            // # 疾病医疗周期
            if (lasttime_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_lasttime");
            }
            // # 疾病治疗方式
            if (cureway_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_cureway");
            }
            // # 疾病治愈可能性
            if (cureprob_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_cureprob");
            }
            // # 疾病易感染人群
            if (easyget_qwds.contains(str) && allEntity.contains("disease")) {
                questionTypesList.add("disease_easyget");
            }
        }
        //若没有查到相关的外部查询信息，那么则将该疾病的描述信息返回
        if (questionTypesList.isEmpty() && allEntity.contains("disease")) {
            questionTypesList.add("disease_desc");
        }
        //若没有查到相关的外部查询信息，那么则将该疾病的描述信息返回
        if (questionTypesList.isEmpty() && allEntity.contains("symptom")) {
            questionTypesList.add("symptom_disease");
        }
        return questionTypesList;
    }
}
