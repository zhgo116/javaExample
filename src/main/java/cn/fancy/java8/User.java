package cn.fancy.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
    private String idcard;
    private String name;
    private int age;


}
