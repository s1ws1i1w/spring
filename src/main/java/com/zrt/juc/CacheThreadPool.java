package com.zrt.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:zrt
 * @Date:2020/10/10-10-10-17:21
 * @Description:com.zrt.juc
 * @version:1.0
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<1000;i++){
            executorService.execute(new Task());
        }
    }
}
