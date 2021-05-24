package org.graduation.knowledge.observer;

/**
 * @author huyuanxin
 */
public interface Subject {

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyObservers();

}
