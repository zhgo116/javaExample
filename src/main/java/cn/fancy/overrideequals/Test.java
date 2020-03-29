package cn.fancy.overrideequals;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试java对象重写Equals
 *
 * 表面上是调用list的contains
 * 实际上是调用泛型实体里去重写equals
 */
public class Test {
    public static void main(String[] args) {
        Menu m1 = new Menu(-1, 0, "功能菜单");
        Menu m2 = new Menu(1, -1, "系统设置");
        List<Menu> ms = new ArrayList<Menu>();
        ms.add(m1);
        ms.add(m2);

        Menu md = new Menu(-1, 0, "功能菜单");
        if (ms.contains(md)) {
            System.out.println("===========");
        }
    }


}


