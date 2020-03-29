package cn.fancy.java8.interfaces;

public interface JDK8Interface {
    //1、接口中可以定义静态方法
    static void staticMethod() {
        System.out.println("接口中的静态方法");
    }

    //2、使用default之后就可以定义普通方法的方法体了
    default void DefaultMethod() {
        System.out.println("接口中的默认方法");
        int a=1;

    }
}