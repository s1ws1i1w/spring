package com.zrt.singleton;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-12:13
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public class LasySingleton  {

    private  static  LasySingleton lasySingleton;

    private LasySingleton(){

    }
    public   static LasySingleton getSingleInstance(){
        if(lasySingleton==null){
            lasySingleton=new LasySingleton();
        }
        return lasySingleton;
    }

}
