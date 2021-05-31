package org.graduation.knowledge.service.common.impl;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.extra.spring.SpringUtil;
import org.graduation.knowledge.mapper.neo4j.*;
import org.graduation.knowledge.observer.Observer;
import org.graduation.knowledge.observer.ObserverUpdateThread;
import org.graduation.knowledge.service.common.AdminService;
import org.graduation.knowledge.service.common.ImportEntityService;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.graduation.knowledge.util.RelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huyuanxin
 */
@Service("ImportEntityService")
public class ImportEntityServiceImpl implements ImportEntityService {
    // 疾病

    final Disease3dMapper disease3dMapper;
    // 并发症

    final Complication3dMapper complication3dMapper;
    final Symptom3dMapper symptom3dMapper;

    final PathologicalType3dMapper pathologicalType3dMapper;
    final Treatment3dMapper treatment3dMapper;
    final Diagnosis3dMapper diagnosis3dMapper;
    final Pathophysiology3dMapper pathophysiology3dMapper;
    final DiseaseSite3dMapper diseaseSite3dMapper;
    final Department3dMapper department3dMapper;
    final MultipleGroups3dMapper multipleGroups3dMapper;
    final Cause3dMapper cause3dMapper;
    final PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper;
    final HighRiskFactors3dMapper highRiskFactors3dMapper;
    final Drug3dMapper drug3dMapper;
    final Prognosis3dMapper prognosis3dMapper;
    final Attribute3dMapper attribute3dMapper;
    final DiseaseRate3dMapper diseaseRate3dMapper;
    final DrugTherapy3dMapper drugTherapy3dMapper;
    final AdjuvantTherapy3dMapper adjuvantTherapy3dMapper;
    final Operation3dMapper operation3dMapper;
    final Pathogenesis3dMapper pathogenesis3dMapper;
    final SymptomAndSign3dMapper symptomAndSign3dMapper;

    //症状

    final Check3dMapper check3dMapper;
    final RelatedDisease3dMapper relatedDisease3dMapper;
    final RelatedSymptom3dMapper relatedSymptom3dMapper;
    final Infectious3dMapper infectious3dMapper;
    final RelatedTo3dMapper relatedTo3dMapper;
    final AuxiliaryExamination3dMapper auxiliaryExamination3dMapper;
    final Stage3dMapper stage3dMapper;
    final TreatmentPrograms3dMapper treatmentPrograms3dMapper;
    final Prevention3dMapper prevention3dMapper;
    final SpreadWay3dMapper spreadWay3dMapper;

    //药物

    final Type3dMapper type3dMapper;
    final Precautions3dMapper precautions3dMapper;
    final Contraindications3dMapper contraindications3dMapper;
    final Subject3dMapper subject3dMapper;
    final Ingredients3dMapper ingredients3dMapper;
    final OTC3dMapper otc3dMapper;
    final AdverseReactions3dMapper adverseReactions3dMapper;
    final Indications3dMapper indications3dMapper;

    //诊疗

    final CheckSubject3dMapper checkSubject3dMapper;

    static List<Observer> observerList = new ArrayList<>();

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 30, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), ThreadFactoryBuilder.create().setNamePrefix("UpdateData").build());
    final AdminService adminService;

    @Autowired
    public ImportEntityServiceImpl(Disease3dMapper disease3dMapper, Symptom3dMapper symptom3dMapper, Complication3dMapper complication3dMapper, PathologicalType3dMapper pathologicalType3dMapper, Treatment3dMapper treatment3dMapper, Diagnosis3dMapper diagnosis3dMapper, Pathophysiology3dMapper pathophysiology3dMapper, DiseaseSite3dMapper diseaseSite3dMapper, Department3dMapper department3dMapper, MultipleGroups3dMapper multipleGroups3dMapper, Cause3dMapper cause3dMapper, PrognosticSurvivalTime3dMapper prognosticSurvivalTime3dMapper, HighRiskFactors3dMapper highRiskFactors3dMapper, Prognosis3dMapper prognosis3dMapper, Attribute3dMapper attribute3dMapper, DiseaseRate3dMapper diseaseRate3dMapper, Drug3dMapper drug3dMapper, DrugTherapy3dMapper drugTherapy3dMapper, AdjuvantTherapy3dMapper adjuvantTherapy3dMapper, Operation3dMapper operation3dMapper, Pathogenesis3dMapper pathogenesis3dMapper, Check3dMapper check3dMapper, RelatedDisease3dMapper relatedDisease3dMapper, RelatedSymptom3dMapper relatedSymptom3dMapper, Infectious3dMapper infectious3dMapper, RelatedTo3dMapper relatedTo3dMapper, SymptomAndSign3dMapper symptomAndSign3dMapper, AuxiliaryExamination3dMapper auxiliaryExamination3dMapper, Stage3dMapper stage3dMapper, TreatmentPrograms3dMapper treatmentPrograms3dMapper, Prevention3dMapper prevention3dMapper, SpreadWay3dMapper spreadWay3dMapper, Type3dMapper type3dMapper, Precautions3dMapper precautions3dMapper, Contraindications3dMapper contraindications3dMapper, Subject3dMapper subject3dMapper, Ingredients3dMapper ingredients3dMapper, OTC3dMapper otc3dMapper, AdverseReactions3dMapper adverseReactions3dMapper, Indications3dMapper indications3dMapper, CheckSubject3dMapper checkSubject3dMapper, AdminService adminService) {
        //疾病
        this.disease3dMapper = disease3dMapper;
        this.complication3dMapper = complication3dMapper;
        this.symptom3dMapper = symptom3dMapper;
        this.pathologicalType3dMapper = pathologicalType3dMapper;
        this.treatment3dMapper = treatment3dMapper;
        this.diagnosis3dMapper = diagnosis3dMapper;
        this.pathophysiology3dMapper = pathophysiology3dMapper;
        this.diseaseSite3dMapper = diseaseSite3dMapper;
        this.department3dMapper = department3dMapper;
        this.multipleGroups3dMapper = multipleGroups3dMapper;
        this.cause3dMapper = cause3dMapper;
        this.prognosticSurvivalTime3dMapper = prognosticSurvivalTime3dMapper;
        this.highRiskFactors3dMapper = highRiskFactors3dMapper;
        this.prognosis3dMapper = prognosis3dMapper;
        this.attribute3dMapper = attribute3dMapper;
        this.diseaseRate3dMapper = diseaseRate3dMapper;
        this.drug3dMapper = drug3dMapper;
        this.drugTherapy3dMapper = drugTherapy3dMapper;
        this.adjuvantTherapy3dMapper = adjuvantTherapy3dMapper;
        this.operation3dMapper = operation3dMapper;
        this.pathogenesis3dMapper = pathogenesis3dMapper;

        //症状
        this.check3dMapper = check3dMapper;
        this.relatedDisease3dMapper = relatedDisease3dMapper;
        this.relatedSymptom3dMapper = relatedSymptom3dMapper;
        this.infectious3dMapper = infectious3dMapper;
        this.relatedTo3dMapper = relatedTo3dMapper;
        this.symptomAndSign3dMapper = symptomAndSign3dMapper;
        this.auxiliaryExamination3dMapper = auxiliaryExamination3dMapper;
        this.stage3dMapper = stage3dMapper;
        this.treatmentPrograms3dMapper = treatmentPrograms3dMapper;
        this.prevention3dMapper = prevention3dMapper;
        this.spreadWay3dMapper = spreadWay3dMapper;

        //药物
        this.type3dMapper = type3dMapper;
        this.precautions3dMapper = precautions3dMapper;
        this.contraindications3dMapper = contraindications3dMapper;
        this.subject3dMapper = subject3dMapper;
        this.ingredients3dMapper = ingredients3dMapper;
        this.otc3dMapper = otc3dMapper;
        this.adverseReactions3dMapper = adverseReactions3dMapper;
        this.indications3dMapper = indications3dMapper;

        //诊疗
        this.checkSubject3dMapper = checkSubject3dMapper;
        this.adminService = adminService;

        registerObserver(this.adminService);

    }

    /**
     * 保存实体
     *
     * @param entities 前端的保存的结果中的entities
     */
    @Override
    public void importEntity(HashMap<String, String> entities) {
        entities.replaceAll((k, v) -> importEntityHandler(k, RelationUtil.getInstance().mappingEntityMap(entities.get(k))));
        ObserverUpdateThread observerUpdateThread = new ObserverUpdateThread(this);
        threadPoolExecutor.execute(observerUpdateThread);
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    private String importEntityHandler(String entityName, String entityType) {
        return Optional.ofNullable(SpringUtil.getBean(entityType + "InsertStrategy"))
                .filter(it -> it instanceof InsertStrategy)
                .map(it -> ((InsertStrategy) it).insertEntity(entityName))
                .orElse("");
    }

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObservers() {
        observerList.forEach(Observer::updateData);
    }
}
