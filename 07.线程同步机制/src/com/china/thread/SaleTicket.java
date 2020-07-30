package com.china.thread;

/**
 * @Author: china wu
 * @Description: 线程同步机制--同步方法
 * @Date: 2020/7/30 12:59
 */
public class SaleTicket {
    public static void main(String[] args) {
        TicketRunnable runnable = new TicketRunnable();
        new Thread(runnable, "1号窗口").start();
        new Thread(runnable, "2号窗口").start();
        new Thread(runnable, "3号窗口").start();
    }
}

class TicketRunnable implements Runnable {

    private int ticketNum = 10;

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