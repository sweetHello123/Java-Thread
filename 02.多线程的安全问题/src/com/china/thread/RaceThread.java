package com.china.thread;

/**
 * @Author: china wu
 * @Description: 龟兔赛跑案例
 * @Date: 2020/7/28 14:24
 */
public class RaceThread implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            // 让兔子线程每跑20步休息1ms
            if ("兔子".equals(Thread.currentThread().getName()) && i % 20 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");

            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
        }
    }

    /**
     * 判断游戏是否结束：先到100步的为胜利者
     *
     * @param step 步数
     * @return
     */
    private static boolean gameOver(int step) {
        if (winner != null) {
            return true;
        } else {
            if (step >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RaceThread raceThread = new RaceThread();
        new Thread(raceThread, "兔子").start();
        new Thread(raceThread, "乌龟").start();
    }
}