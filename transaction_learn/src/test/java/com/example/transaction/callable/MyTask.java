package com.example.transaction.callable;

import java.util.concurrent.Callable;

/**
 * @Auther: liXu
 * @Date: 2020/8/30 17:50
 * @Description:
 */
class MyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程开始计算...");
        for (int i=0;i<3;++i){
            Thread.sleep(1000);
            System.out.println("子线程计算中，用时 "+(i+1)+" 秒");
        }
        System.out.println("子线程计算完成，返回：100");
        return 100;
    }
}