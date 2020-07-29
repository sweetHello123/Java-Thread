package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试守护线程
 * @Date: 2020/7/29 21:41
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        NormalThread normalThread = new NormalThread();
        DaemonThread daemonThread = new DaemonThread();

        Thread t1 = new Thread(normalThread);
        t1.start();

        Thread t2 = new Thread(daemonThread);
        // 设置为守护线程，默认都是用户线程
        t2.setDaemon(true);
        // 守护线程用于守护其他用户线程，且jvm不用关心守护线程是否执行完毕，只要用户线程执行完毕就退出
        t2.start();
    }
}

class NormalThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是用户线程--" + i);
        }
        System.out.println("用户线程结束");
    }
}

class DaemonThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("我是守护线程");
        }
    }
}