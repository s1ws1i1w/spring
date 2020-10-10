package com.zrt.singleton;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-13:04
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public class StaticInnerSingleton {
    private StaticInnerSingleton(){

    }
    private static class StaticInner{
        private  static  StaticInnerSingleton staticInnerSingleton;
    }
    public  StaticInnerSingleton getInstance(){
          return StaticInner.staticInnerSingleton;
    }
}
