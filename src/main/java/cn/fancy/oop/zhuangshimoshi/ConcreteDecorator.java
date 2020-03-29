package cn.fancy.oop.zhuangshimoshi;

public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component com) {
        super(com);
        // TODO Auto-generated constructor stub
    }
    //重写方法
    public void display() {
        super.display();
        this.setMyMethod();
    }
    public void setMyMethod() {
        System.out.println("添加装饰方法");
    }
}