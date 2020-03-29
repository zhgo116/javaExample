package cn.fancy.java8.stream;

public class Dish {
    private String name;
    private boolean zhushi;
    private int reliang;
    private Integer type;

    public Dish(String name, boolean zhushi, int reliang, Integer type) {
        this.name = name;
        this.zhushi = zhushi;
        this.reliang = reliang;
        this.type = type;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isZhushi() {
        return zhushi;
    }

    public void setZhushi(boolean zhushi) {
        this.zhushi = zhushi;
    }

    public int getReliang() {
        return reliang;
    }

    public void setReliang(int reliang) {
        this.reliang = reliang;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", zhushi=" + zhushi +
                ", reliang=" + reliang +
                ", type=" + type +
                '}';
    }
}
