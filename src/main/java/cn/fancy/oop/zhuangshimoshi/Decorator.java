package cn.fancy.oop.zhuangshimoshi;

public class Decorator extends Component {
    private Component component;
    public Decorator(Component com) {
        this.component=com;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        component.display();
        System.out.println(component.getClass().toString());

    }

}