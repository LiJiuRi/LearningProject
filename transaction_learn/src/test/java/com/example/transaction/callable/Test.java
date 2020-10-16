package com.example.transaction.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Auther: liXu
 * @Date: 2020/8/30 17:51
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        MyTask task = new MyTask();
        System.out.println("主线程启动线程池");
        Future<Integer> future = executor.submit(task);
        System.out.println("主线程得到返回结果："+future.get());
        executor.shutdown();
    }
}
