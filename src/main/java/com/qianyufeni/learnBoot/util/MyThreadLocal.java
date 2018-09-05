package com.qianyufeni.learnBoot.util;

public class MyThreadLocal {
    //threadLocal用来存储同一个线程的共享变量
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static String getMessage() {
        return threadLocal.get();
    }

    public static void setMessage(String message){
        threadLocal.set(message);
    }
}
