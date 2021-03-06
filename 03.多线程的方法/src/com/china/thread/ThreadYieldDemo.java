package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试线程礼让--运行状态->就绪状态(线程暂停但不阻塞)
 * @Date: 2020/7/29 12:26
 */
public class ThreadYieldDemo {
    public static void main(String[] args) {
        YieldThread thread0 = new YieldThread();
        YieldThread thread1 = new YieldThread();
        new Thread(thread0, "线程1").start();
        new Thread(thread1, "线程2").start();
    }
}

class YieldThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        // 调用礼让方法，不一定成功看cpu心情
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}