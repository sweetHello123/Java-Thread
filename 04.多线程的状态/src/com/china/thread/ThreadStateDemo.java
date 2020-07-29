package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试多线程的各个状态
 * @Date: 2020/7/29 20:10
 */
public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("我是新线程");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 线程启动前，状态为NEW
        Thread.State state = thread.getState();
        System.out.println("启动前：" + state);

        // 线程启动后，状态为RUNNABLE
        thread.start();
        state = thread.getState();
        System.out.println("启动后：" + state);

        // 只要当前线程状态不是终止的，一直打印出线程状态
        while (state != Thread.State.TERMINATED) {
            state = thread.getState();
            System.out.println(state);
        }
    }
}