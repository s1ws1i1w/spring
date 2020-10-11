package com.zrt.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ThreadLocalNormalUsage001 {

     static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");;
    public static void main(String[] args) {

        ThreadLocalNormalUsage001 threadLocal1 = new ThreadLocalNormalUsage001();
        for(int i=0;i<1000;i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(threadLocal1.getdata(finalI));
                }
            }).start();
        }
    }

    public  String getdata(int Seconds){
        synchronized (ThreadLocalNormalUsage001.class) {
            Date date = new Date(1000 * Seconds);
            return simpleDateFormat.format(date);
        }
    }

}
