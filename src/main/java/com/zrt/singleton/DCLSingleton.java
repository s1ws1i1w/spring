package com.zrt.singleton;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-12:45
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public class DCLSingleton{

    private static volatile DCLSingleton dclSingleton;

    private DCLSingleton(){

    }
    public static  DCLSingleton getInstance(){
        if(dclSingleton==null){
            synchronized (DCLSingleton.class){
                if(dclSingleton==null){
                    dclSingleton=new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
