package org.graduation.knowledge.service.common.impl;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.extra.spring.SpringUtil;
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

    static List<Observer> observerList = new ArrayList<>();

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 30, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), ThreadFactoryBuilder.create().setNamePrefix("UpdateData").build());
    final AdminService adminService;

    @Autowired
    public ImportEntityServiceImpl(AdminService adminService) {
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
