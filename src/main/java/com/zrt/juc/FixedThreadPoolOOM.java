package com.zrt.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟newFixedThreadPool的OOM情况
 */

public class FixedThreadPoolOOM {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for(int i=0;i<Integer.MAX_VALUE;i++){
            executorService.execute(new Task());
        }
    }
}
class Task implements  Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
