package com.simpleframewrok.spring.utils;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;


/**
 * @Author:zrt
 * @Date:2020/8/9-08-09-0:23
 * @Description:com.simpleframewrok.spring
 * @version:1.0
 */
public class CUtils  {
    //根据传入的包名获取包路径下的所有类
    public static Set<Class<?>> getPackage(String packageName) {
        ClassLoader classLoader = CUtils.getClassLoader();
        String s = packageName.replace(".","/");
        URL url = classLoader.getResource(s);
        if(url==null){
           return null;
       }
        Set<Class<?>> classSet=null;
       if(url.getProtocol().equalsIgnoreCase("file")){
           classSet=new HashSet<Class<?>>();
           File PackageDirectory=new File(url.getPath());
          extractClassFile(classSet,PackageDirectory,packageName);

       }

        return classSet;

    }

    private static void extractClassFile(final Set<Class<?>> classSet, File packageDirectory, final String packageName) {
        if(!packageDirectory.isDirectory()){
            return;
        }
        final File[] files = packageDirectory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    return true;
                }
                else{
                    //获取文件的绝对值路径
                    String absoluteFilePath=pathname.getAbsolutePath();
                    if(absoluteFilePath.endsWith("class")){
                       //若是class文件,则直接加载
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }
          //根据class文件的绝对路径,获取并生成class对象,并放入classSet对象当中
            private void addToClassSet(String absoluteFilePath) {
                absoluteFilePath=absoluteFilePath.replace(File.separator,".");
                String className=absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
               className=className.substring(0,className.lastIndexOf("."));
                //通过反射机制将当前类加载
                loadClass(className);
                classSet.add(loadClass(className));
            }
        });
        if(files!=null){
            for (File file : files) {
                extractClassFile(classSet,file,packageName);
            }

        }


    }

    public static Class<?>loadClass(String className){
        try {
            return  Class.forName(className);
        } catch (ClassNotFoundException e) {
          throw new RuntimeException("");
        }
    }


    //获取当前的类加载器
    public static   ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        getPackage("com.simpleframewrok.spring");
    }

}
