package org.graduation.knowledge.observer;

/**
 * @author huyuanxin
 */
public class ObserverUpdateThread implements Runnable {

    final private Subject subject;

    public ObserverUpdateThread(Subject subject) {
        this.subject = subject;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        this.subject.notifyObservers();
    }

}
