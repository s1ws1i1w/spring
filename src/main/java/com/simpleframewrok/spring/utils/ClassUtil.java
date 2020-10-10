package com.simpleframewrok.spring.utils;

import java.lang.reflect.Constructor;

/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-20:49
 * @Description:com.simpleframewrok.spring.utils
 * @version:1.0
 */
public class ClassUtil {

    public static  <T> T getInstance(Class<?> clazz,boolean accessible){
        try {
            Constructor<?> constructor = clazz.getConstructor();
            constructor.setAccessible(accessible);
            return (T)clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("出现异常");
        }

    }
}
