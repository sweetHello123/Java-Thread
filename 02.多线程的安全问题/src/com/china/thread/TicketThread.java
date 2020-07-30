package com.china.thread;

/**
 * @Author: china wu
 * @Description: 多线程实现卖票案例模拟并发
 * 问题:多个线程操作同一资源时，线程不安全，数据紊乱
 * @Date: 2020/7/28 13:56
 */
public class TicketThread implements Runnable {

    /**
     * 总票数
     */
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出" + ticketNum-- + "号票");
        }
    }

    public static void main(String[] args) {
        com.china.thread.TicketThread ticketThread = new com.china.thread.TicketThread();
        new Thread(ticketThread, "1号窗口").start();
        new Thread(ticketThread, "2号窗口").start();
        new Thread(ticketThread, "3号窗口").start();
    }
}