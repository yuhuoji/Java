package com.practice;

public class CodeOuterClass {
    private final int value = 10;

    public static void main(String[] args) {
        CodeOuterClass outer = new CodeOuterClass();
        InnerClass inner = outer.new InnerClass();
        inner.doSomething();
    }

    public class InnerClass {
        private final int value = 20;

        public void doSomething() {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
            System.out.println("Inner this.value: " + this.value); // 引用匿名内部类的实例变量
            System.out.println("Outer this.value: " + CodeOuterClass.this.value); // 引用外部类的实例变量
//                }
//            };
//            new Thread(runnable).start();
        }
    }
}

