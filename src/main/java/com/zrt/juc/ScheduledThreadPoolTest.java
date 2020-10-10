package com.zrt.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.schedule(new Task(),5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Task(),1,3,TimeUnit.SECONDS);
    }
}
