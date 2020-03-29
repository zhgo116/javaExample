package cn.fancy.java8.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListCollectionTest {

    public static void main(String []args) {
        //1.分组计数
        List<Student> list = Arrays.asList(
                new Student(1, "one", "zhao",11),
                new Student(2, "one", "qian",22),
                new Student(3, "two", "sun",33),
                new Student(4, "two", "lee",18));


        //1.1根据某个属性分组计数
        Map<String, Long> result1 = list.stream().collect(Collectors.groupingBy(Student::getGroupId, Collectors.counting()));
        System.out.println(result1);

        //1.2根据整个实体对象分组计数,当其为String时常使用
        Map<Student, Long> result2 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result2);

        //1.3根据分组的key值对结果进行排序、放进另一个map中并输出
        Map<String, Long> xMap = new HashMap<>();
        result1.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed()) //reversed不生效
                .forEachOrdered(x -> xMap.put(x.getKey(), x.getValue()));
        System.out.println(xMap);

    }


}
