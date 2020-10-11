package com.zrt.threadLocal;

/**
 *    将信息保存在本地线程中,既避免了使用
 */

public class ThreadLocalNormalUsage006 {

    public static void main(String[] args) {
        UserHolder.threadLocal.set(new User("王云影"));
        new Service1().process();
    }
}

class Service1{
      public void process(){
          System.out.println(UserHolder.threadLocal.get().name);
          new Service2().process();
      }
}
class Service2{
       public  void  process(){
           System.out.println(UserHolder.threadLocal.get().name);
           new Service3().process();
       }
}
class Service3{
      public  void process(){

          System.out.println(UserHolder.threadLocal.get().name);
      }
}
class UserHolder{
      static  ThreadLocal<User> threadLocal=new ThreadLocal<>();
}

class User{
    String name;
    public User(String username){
        this.name=username;
    }

}
