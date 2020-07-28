package com.china.thread;

/**
 * @Author: china wu
 * @Description: 创建新线程的第一种方式：继承Thread类，重写run方法
 * @Date: 2020/7/28 12:33
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是新线程--" + i);
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        MyThread myThread = new MyThread();
        // 调用start()开启新线程，与主线程并行执行
        myThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程--" + i);
        }
    }
}