package com.zrt.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:   利用ThreadLocal,给每个线程分配自己的dateFormat对象,保证了线程安全;此种方式是基于线程池
 *
 */
public class ThreadLocalNormalUsage002 {

    public static void main(String[]args) {
        ThreadLocalNormalUsage002 threadLocal=new ThreadLocalNormalUsage002();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<1000;i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String data = threadLocal.data(finalI);
                    System.out.println(data);
                }
            });
        }
    }

     public String data(int seconds){
         Date date=new Date(seconds*1000);
        SimpleDateFormat simpleDateFormat=ThreadLoaclFormater.threadLocal.get();
         return simpleDateFormat.format(date);
     }

}

class ThreadLoaclFormater{
    static ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
         return new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
        }
    };
}
