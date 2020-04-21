package cn.fancy.plugin.loombok;

public class Test {
    public static void main(String[] args) {
        User.Builder c = new User.Builder().id(1).address("安徽").name("操圣");
        System.out.println(c.toString());

       Dog.DogBuilder d= Dog.builder().id(1)
                .address("北京").name("销毁");
        System.out.println(d.toString());
    }

}
