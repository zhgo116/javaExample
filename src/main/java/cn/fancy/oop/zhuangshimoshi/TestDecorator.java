package cn.fancy.oop.zhuangshimoshi;

/**
 * 装饰模式：动态地给一个对象增加一些额外的职责。就扩张功能而言，装饰模式提供了一种比使用子类更加灵活的替代方案。
 *
 * 装饰模式的优缺点及使用场景
 * 优点：
 *
 * 对于扩张一个对象的功能，装饰模式比继承模式更加灵活，不会导致类的数量急剧增加。
 * 可以通过一种动态的方式扩张一个类的功能，同过配置文件可以在运行时济宁选择，不同的装饰类。
 * 可以对一个对象进行多次装饰，通过使用不同的具体装饰类以及这些装饰类的排列组合可以创造不同的行为的组合。
 * 缺点：
 *
 * 在使用装饰模式的时候进行系统设计时会产生很多小对象，这些对象的区别在于他们之间相互连接的方式有所不同，而不是他们的类或者属性值有所不同，大量小对象势必产生一大部分的系统资源开销。影响系统性能。
 * 装饰模式是一种比继承更加灵活的解决方案。但同时，也意味着比继承更加容易出错，更加难排长。对于多层装饰的对象，需要逐级排查，较为繁琐。
 * 使用场景：
 *
 * 在不影响其他对象的情况下以动态的，透明的方式给单个对象添加职责。
 * 不能用继承进行扩张的时候。
 *
 * 总结
 * 装饰模式在某些不方便用继承的时候是非常好用的一个模式，毕竟不用写太多的类。但是我建议不要装饰太多次，因为显然，如果装饰太多层，
 * 进行排查的时候会非常的麻烦。而我就是怕麻烦的人。
 *

 */
public class TestDecorator {
    public static void main(String[] args) {
        Component com = new ConcreteComponent();
        Component d1 = new ConcreteDecorator(com);
      //  d1.display();
        //装饰过后的方法还可以再次装饰
        Component d2 = new ConcreteDecorator2(d1);
        d2.display();
    }
}