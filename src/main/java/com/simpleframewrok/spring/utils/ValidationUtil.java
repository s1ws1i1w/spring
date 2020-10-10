package com.simpleframewrok.spring.utils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-20:51
 * @Description:com.simpleframewrok.spring.utils
 * @version:1.0
 */
public class ValidationUtil {

    /**
     * Collection是否为Null或size为0
     */

    public static boolean isEmpty(Collection<?> obj){
        return obj==null||obj.isEmpty();
    }

}
