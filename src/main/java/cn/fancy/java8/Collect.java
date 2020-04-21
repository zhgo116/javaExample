package cn.fancy.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<User> users = getList();
        List idcards = new ArrayList();
        for (int i = 0; i < users.size(); i++) {
            idcards.add(users.get(i).getIdcard());
        }
        System.out.println(idcards);

        System.out.println(users.stream().map(User::getIdcard).collect(Collectors.toList()));




        List dd  =users.stream().map(User::getIdcard).collect(Collectors.toList());//一行实现

        List<String> list = Arrays.asList("a", "b", "c", "d");

        List collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]

    }

    private static List<User> getList() {
        List<User> u = new ArrayList<>();
        u.add(new User("1234", "net", 12));
        u.add(new User("90999", "java", 1111));
        return u;
    }
}
