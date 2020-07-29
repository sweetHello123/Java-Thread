package com.china.thread;

/**
 * @Author: china wu
 * @Description: 测试线程休眠--阻塞状态
 * @Date: 2020/7/29 12:01
 */
public class ThreadSleepDemo{
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        while (true) {
            System.out.println(num--);
             // sleep可以模拟网络延时、倒计时(时间到达后进入就绪状态)
            Thread.sleep(1000);
            if (num == 0) {
                break;
            }
        }
    }
}