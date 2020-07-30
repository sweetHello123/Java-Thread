package com.china.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: china wu
 * @Description: 同步机制--Lock锁：手动开启和关闭锁(显示锁)
 * @Date: 2020/7/30 18:37
 */
public class LockDemo {
    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        new Thread(saleTicket, "1号窗口").start();
        new Thread(saleTicket, "2号窗口").start();
        new Thread(saleTicket, "3号窗口").start();
    }

    static class SaleTicket implements Runnable {

        private int ticketNum = 200;

        // 定义lock锁(可重用锁)
        private final ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            sale();
        }

        private void sale() {
            boolean flag = true;
            while (flag) {
                try {
                    // 给不安全的代码加锁
                    lock.lock();
                    if (ticketNum <= 0) {
                        flag = false;
                        return;
                    }
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "卖出" + ticketNum-- + "号票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 执行完解锁
                    lock.unlock();
                }
            }
        }
    }
}