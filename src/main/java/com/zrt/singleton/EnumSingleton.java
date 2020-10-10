package com.zrt.singleton;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-17:25
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public enum EnumSingleton {
    Instance{
        protected void get(){
            System.out.println("sss1");
        }
    };
   private  Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){
        return EnumSingleton.Instance;
    }
}
