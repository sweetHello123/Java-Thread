package com.china.thread;

/**
 * @Author: china wu
 * @Description: 线程同步机制--同步方法(隐式锁)
 * @Date: 2020/7/30 12:59
 */
public class SynMethodDemo {
    public static void main(String[] args) {
        SaleTicket runnable = new SaleTicket();
        new Thread(runnable, "1号窗口").start();
        new Thread(runnable, "2号窗口").start();
        new Thread(runnable, "3号窗口").start();
    }

    static class SaleTicket implements Runnable {

        private int ticketNum = 200;

        @Override
        public void run() {
            sale();
        }

        /**
         * 同步方法：加上synchronized修饰符，默认给this加锁
         */
        private synchronized void sale() {
            boolean flag = true;
            while (flag) {
                if (ticketNum <= 0) {
                    flag = false;
                    return;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出" + ticketNum-- + "号票");
            }
        }
    }
}