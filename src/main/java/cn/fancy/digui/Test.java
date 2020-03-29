package cn.fancy.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试java递归树结构
 */
public class Test {
    public static void main(String[] args) {
        Menu m1 = new Menu(-1, 0, "功能菜单");
        Menu m2 = new Menu(1, -1, "系统设置");
        Menu m3 = new Menu(2, 1, "邮件设置");
        Menu m4 = new Menu(3, 2, "SMT详细配置");
        Menu m5 = new Menu(4, -1, "用户设置");
        Menu m6 = new Menu(5, 4, "用户列表");
        Menu m7 = new Menu(6, 5, "新增用户");
        List<Menu> ms = new ArrayList<Menu>();
        ms.add(m1);
        ms.add(m2);
        ms.add(m3);
        ms.add(m4);
        ms.add(m5);
        ms.add(m6);
        ms.add(m7);
        List<Menu> root = new ArrayList<>();
        //第一步，查找根节点
        for (Menu m : ms) {
            if (m.getPid() == 0) {
                root.add(m);
                break;
            }
        }
        //递归根节点所有子节点，并且存放到根节点的子节点集合中
        Menu rootMenu = root.get(0);
        rootMenu.setChilds(recursor(rootMenu.getId(), ms));
        System.out.println(root);
    }

    /**
     * 根据父亲节点递归所有子节点
     *
     * @param pid 根节点编号
     * @param ms  原始集合
     */
    public static List<Menu> recursor(int pid, List<Menu> ms) {
        List<Menu> child = new ArrayList<>();
        for (Menu m : ms) {
            if (m.getPid() == pid) {
                child.add(m);
            }
        }
        for (Menu ch : child) {
            ch.setChilds(recursor(ch.getId(), ms));
        }
        if (child.size() == 0) {
            return null;
        }
        return child;
    }
}


