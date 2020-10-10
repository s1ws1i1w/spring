package com.simpleframework.spring;

import com.simpleframewrok.spring.utils.CUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-17:14
 * @Description:com.simpleframework.spring
 * @version:1.0
 */
public class CUtilsTest {

    @DisplayName("提取目标类的方法:extractPackageClassTest")
    @Test
    public void extracePackageClassTest(){
        Set<Class<?>> aPackage = CUtils.getPackage("com.simpleframewrok.spring");
        System.out.println(aPackage);
    }

}
