package com.simpleframewrok.spring.core;

import com.simpleframewrok.spring.annotation.Component;
import com.simpleframewrok.spring.annotation.Controller;
import com.simpleframewrok.spring.annotation.Service;
import com.simpleframewrok.spring.utils.CUtils;
import com.simpleframewrok.spring.utils.ClassUtil;
import com.simpleframewrok.spring.utils.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-20:38
 * @Description:com.simpleframewrok.spring.core
 * @version:1.0
 */
public class BeanContainer {
   private final Map<Class<?>,Object> beanMap=new ConcurrentHashMap<>();
   private static  List<Class<? extends Annotation>>BEAN_ANNOTATION= Arrays.asList(Component.class, Controller.class, Service.class);

   public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

   private enum  ContainerHolder{
         HOLDER;
         private BeanContainer instance;
         ContainerHolder(){
             instance=new BeanContainer();
         }
    }
   private boolean loaded=false;

    /**
     * 扫描加载所有Bean
      */

   public boolean isLoaded(){
       return loaded;
   }
    public synchronized  void loadBeans(String packName){
       //判断容器是否被加载过
        if(isLoaded()){
            return;
        }
        Set<Class<?>> classes = CUtils.getPackage(packName);
        if(ValidationUtil.isEmpty(classes)){
            return;
        }
        for(Class<?> clazz:classes){
            for(Class<? extends  Annotation> annotation:BEAN_ANNOTATION){
                if(clazz.isAnnotationPresent(annotation)){
                    beanMap.put(clazz, ClassUtil.getInstance(clazz,true));
                }
            }

        }
        loaded=true;
    }


}
