package cn.fancy.overrideequals;

import java.util.List;


class Menu {
    private int id;
    private int pid;
    private String name;
    private List<Menu> childs;

    /**
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Menu)) return false;
        if (this.getId() == ((Menu) obj).getId()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", childs=" + childs +
                '}';
    }

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }

    public Menu() {
    }

    public Menu(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}