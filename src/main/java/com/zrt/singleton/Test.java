package com.zrt.singleton;

import java.io.*;

/**
 * @Author:zrt
 * @Date:2020/8/8-08-08-12:14
 * @Description:com.zrt.singleton
 * @version:1.0
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
         EnumSingleton enumSingleton=EnumSingleton.getInstance();
         ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("zrt.txt"));
         obj.writeObject(enumSingleton);
         File file=new File("zrt.txt");
         ObjectInputStream ip=new ObjectInputStream(new FileInputStream(file));
        EnumSingleton o = (EnumSingleton)ip.readObject();
        System.out.println(o==enumSingleton);
    }


}

class LasySingeltonTask extends   Thread{
    @Override
    public void run() {
        DCLSingleton dclSingleton=DCLSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+" "+dclSingleton);
    }
}
