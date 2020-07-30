package com.china.thread;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/7/30 12:59
 */
public class SaleTicket {
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread, "1号窗口").start();
        new Thread(ticketThread, "2号窗口").start();
        new Thread(ticketThread, "3号窗口").start();
    }
}

class Ticket implements Runnable {

    private int ticketNum = 10;

    @Override
    public void run() {
        sale();
    }

    private void sale() {
        boolean flag = true;
        if (ticketNum <= 0) {
            flag = false;
        }
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "卖出" + ticketNum-- + "号票");
        }
    }
}