package com.zrt.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列和newFixedThreadPool相似
 *
 */
public class SingleThreadExcutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<1000;i++){
            executorService.execute(new Task());
        }
    }
}
