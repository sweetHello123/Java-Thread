package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试线程合并
 * @Date: 2020/7/29 13:29
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("我是main线程--" + i);
            if (i == 50) {
                // 调用join方法让此线程优先执行完毕，其他线程等待
                System.out.println("新线程准备插队");
                // 新线程合并到主线程中，主线程暂停执行转而执行新线程任务，直到新线程执行完毕后继续
                thread.join();
            }
        }
    }
}

class JoinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是新线程--" + i);
        }
    }
}