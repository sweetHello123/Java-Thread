package com.china.thread;

/**
 * @Author: china wu
 * @Description: 创建多线程的第二种方式：实现Runnable接口，重写run方法(推荐)
 * @Date: 2020/7/28 12:51
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是新线程--" + i);
        }
    }

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        MyRunnable myRunnable = new MyRunnable();

        // 创建线程对象并传入Runnable实现类对象，通过线程对象开启线程
        new Thread(myRunnable).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程--" + i);
        }
    }
}