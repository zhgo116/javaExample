package cn.fancy.oop.zhuangshimoshi;

public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component com) {
        super(com);
        // TODO Auto-generated constructor stub
    }

    //重写display方法
    public void display() {
        super.display();
        this.shou();
    }

    public void shou() {
        System.out.println("这是装饰方法2");
    }
}