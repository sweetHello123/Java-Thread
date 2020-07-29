package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试线程的优先级--优先级高低不影响cpu调度线程的顺序
 * @Date: 2020/7/29 21:21
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // 输出主线程名与优先级
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());

        PriorityThread thread = new PriorityThread();

        Thread t1 = new Thread(thread);
        t1.setPriority(1);
        t1.start();

        Thread t2 = new Thread(thread);
        t2.setPriority(10);
        t2.start();

        Thread t3 = new Thread(thread);
        t3.setPriority(5);
        t3.start();

        Thread t4 = new Thread(thread);
        t4.setPriority(8);
        t4.start();
    }
}

class PriorityThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
    }
}