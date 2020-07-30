package com.china.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: china wu
 * @Description: 同步机制--同步代码块
 * @Date: 2020/7/30 13:54
 */
public class SynCodeBlockDemo {
    public static void main(String[] args) {
        // ArrayList线程不安全，可以利用同步代码块解决
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 使用同步代码块，给共享对象加锁
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}