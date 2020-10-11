package com.zrt.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ThreadLocalNormalUsage000 {
    public static void main(String[] args) {

        ThreadLocalNormalUsage000 threadLocal = new ThreadLocalNormalUsage000();
         new Thread(new Runnable() {
            @Override
            public void run() {
                String data = threadLocal.data(1000);
                System.out.println(data);
            }
        }).start();
         new Thread(new Runnable() {
             @Override
             public void run() {
                 String data = threadLocal.data(100000);
                 System.out.println(data);
             }
         }).start();
    }

    public String data(int Seconds){
        Date date=new Date(1000*Seconds);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       return  simpleDateFormat.format(date);
    }



}
