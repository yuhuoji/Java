package com.practice;

public class CodeSingleton {
    private volatile static CodeSingleton instance; //volatile让重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前；DCL错误

    private CodeSingleton() {
    }

    public static CodeSingleton getInstance() {
        if (null == instance) {
            synchronized (CodeSingleton.class) {
                if (null == instance) {
                    instance = new CodeSingleton();   // error 重排序 1.分配内存空间 2.初始化对象 3.将对象指向刚分配的内存空间
                }
            }
        }
        return instance;
    }
}
