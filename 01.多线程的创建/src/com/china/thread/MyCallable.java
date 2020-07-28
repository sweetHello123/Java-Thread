package com.china.thread;

import java.util.concurrent.*;

/**
 * @Author: china wu
 * @Description: 创建线程的第三种方式：实现Callable接口，重写call方法并指定返回值类型
 * @Date: 2020/7/28 14:55
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "myCallable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        MyCallable myCallable2 = new MyCallable();
        // 创建执行任务
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 提交执行
        Future<String> future = executorService.submit(myCallable);
        Future<String> future2 = executorService.submit(myCallable2);
        // 获取结果
        String result = future.get();
        String result2 = future2.get();
        System.out.println(result);
        System.out.println(result2);

        // 关闭服务
        executorService.shutdownNow();
    }
}