package cn.fancy.plugin.loombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dog {
    private Integer id;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    
}
