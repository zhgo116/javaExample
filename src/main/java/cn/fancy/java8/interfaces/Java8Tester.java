package cn.fancy.java8.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Java8Tester {
    public static void main(String args[]) {
        List<Car> names = new ArrayList<Car>();

        names.add(new Car("java", 1));
        names.add(new Car("net", 2));
        names.add(new Car("c#", 3));
        names.add(new Car("winform", 4));
        names.add(new Car("c++", 5));

        names.forEach(e -> System.out.println(e.getAge()));
//多行代码的形式
        names.forEach(e -> {

            System.out.println(e.getAge());
        });
        JDK8Interface.staticMethod();
    }
}
