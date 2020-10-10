package com.simpleframework.spring.core;

import com.simpleframewrok.spring.core.BeanContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-20:56
 * @Description:com.simpleframework.spring.core
 * @version:1.0
 */
public class BeanContainerTest {

      private static BeanContainer beanContainer;
      @BeforeAll
      static void init(){
          beanContainer = BeanContainer.getInstance();
      }

      @Test
      public void loadBeansTest(){
          Assertions.assertEquals(false,beanContainer.isLoaded());
          beanContainer.loadBeans("com.simpleframewrok.spring");
          Assertions.assertEquals(true,beanContainer.isLoaded());

      }
}
