package com.gwh.designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 *
 * 应用场景
 * 1.当对象之间存在复杂的网状结构关系而导致依赖关系混乱切难以复用时
 * 2.当想创建一个运行于多个类之间的对象，又不想生成新的子类时
 *
 */
public class MediatorTest {

    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1,c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();

        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("---------------");
        //c2.send();

    }

}

/**
 * 抽象中介者类
 */
abstract class Mediator{

    // 注册
    public abstract void register(Colleague colleague);

    // 转发
    public abstract void relay(Colleague cl);

}

/**
 * 具体中介者
 */
class ConcreteMediator extends Mediator{

    private List<Colleague> colleagues = new ArrayList<Colleague>();

    // 注册对象
    @Override
    public void register(Colleague colleague){
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    // 遍历集合，执行消息发送
    @Override
    public void relay(Colleague cl){
        for (Colleague ob:colleagues){
            if(!ob.equals(cl)){
                ob.receive();
            }

        }

    }


}

/**
 * 抽象同事类
 */
abstract class Colleague{

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();

}

/**
 * 具体同事类1
 */
class ConcreteColleague1 extends Colleague{

    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类1发出请求");
        mediator.relay(this);
    }
}

/**
 * 具体同事类2
 */
class ConcreteColleague2 extends Colleague{

    @Override
    public void receive() {
        System.out.println("具体同事类2收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类2发出请求");
        mediator.relay(this);
    }
}