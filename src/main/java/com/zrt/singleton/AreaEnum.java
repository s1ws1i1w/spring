package com.zrt.singleton;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-17:35
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public enum AreaEnum {
    GS("广州"){
        @Override
        public void sayHello() {
            System.out.println(111);
        }
    },
    SZ("深圳"){
        @Override
        public void sayHello() {
            System.out.println(222);
        }
    };
    private String data;

    public abstract  void sayHello();
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    AreaEnum(String data) {
        this.data = data;
    }
}
