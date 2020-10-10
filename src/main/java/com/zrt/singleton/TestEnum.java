package com.zrt.singleton;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-17:36
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public class TestEnum {

    public static void main(String[] args) {
        String data = AreaEnum.GS.getData();
        AreaEnum.GS.sayHello();
        System.out.println(data);
    }
}
