package cn.fancy.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String groupId;
    private String name;
    private Integer age;
}