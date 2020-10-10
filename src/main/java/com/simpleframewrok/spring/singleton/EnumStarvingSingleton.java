package com.simpleframewrok.spring.singleton;

import com.simpleframewrok.spring.annotation.Controller;

/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-18:05
 * @Description:com.simpleframewrok.spring.singleton
 * @version:1.0
 */
@Controller
public class EnumStarvingSingleton {

    public EnumStarvingSingleton getInstance(){
       return ContainerHolder.HOLDER.instance;
    }
    public enum ContainerHolder{
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder(){
            instance=new EnumStarvingSingleton();
        }
    }
}
