package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试线程停止--死亡状态
 * @Date: 2020/7/29 11:34
 */
public class ThreadStopDemo implements Runnable {

    /**
     * 定义一个标志位用于线程的停止
     */
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("我是新线程--" + i++);
        }
    }

    /**
     * 自定义停止线程的方法
     */
    private void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStopDemo th = new ThreadStopDemo();
        new Thread(th).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("我是main线程--" + i);
            if (i == 50) {
                // 调用stop方法切换标志位，让线程停止
                th.stop();
                System.out.println("新线程停止了");
            }
        }
    }
}