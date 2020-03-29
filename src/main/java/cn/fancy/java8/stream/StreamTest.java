package cn.fancy.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest {
    public static void main(String[] args) {
        final ArrayList<Dish> dishes = Lists.newArrayList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH)
        );


        //直接连接
        String join1 = dishes.stream().map(Dish::getName).collect(Collectors.joining());
        //逗号
        String join2 = dishes.stream().map(Dish::getName).collect(Collectors.joining(", "));

        Stream<String> cd = dishes.stream().map(Dish::getName);
        System.out.println("join1-----" + join1);
        System.out.println("join1-----" + join2);


        Map<Integer, Dish> map = dishes.stream().collect(Collectors.toMap(Dish::getType, d -> {
            //System.out.println(d);
            return d;
        }, (oldValue, newValue) -> {
            //System.out.println(newValue + "---" + oldValue);
            return oldValue;
        }));

        //通过对map entrySet的遍历，也可以同时拿到key和value，一般情况下，性能上要优于上一种,这一种也是最常用的遍历方法
        for (Map.Entry<Integer, Dish> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            //map.entrySet().remove(entry);   报错
        }

        System.out.println(map.size());
        //但Iterator也有其优势：在用foreach遍历map时，如果改变其大小，会报错，但如果只是删除元素，可以使用Iterator的remove方法删除元素
        Iterator<Map.Entry<Integer, Dish>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Dish> entry = it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
            it.remove();
           // System.out.println(it);
        }
       // System.out.println(map.size());
    }
}
