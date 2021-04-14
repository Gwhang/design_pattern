package com.gwh.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 1.对象间存在一对多个关系，一个对象的状态改变会影响其他对象
 * 2.当一个抽象模型有两个方面，其中一个方面依赖于另一方面时，可将这二者封装在独立的对象中以使他们可以各自独立的改变和复用
 *
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 得到具体目标对象
        Subject subject = new ConcreteSubject();
        // 得到具体抽象对象
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();

    }

}



/**
 * 抽象目标
 */
abstract class Subject{

    protected List<Observer> observers = new ArrayList<Observer>();

    // 增加观察者方法
    protected void add(Observer observer){
        observers.add(observer);
    }

    // 删除观察者方法
    protected void remove(Observer observer){
        observers.remove(observer);
    }

    // 通知观察者方法
    public abstract void notifyObserver();

}

/**
 * 具体目标
 */
class ConcreteSubject extends Subject{

    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生变化");
        System.out.println(".................");
        for (Observer obj:observers){
            // 发生变化
            obj.response();
        }

    }
}

/**
 * 抽象观察者
 */
interface Observer{
    // 反应
    void response();
}

/**
 * 具体观察者1
 */
class ConcreteObserver1 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应");
    }
}
/**
 * 具体观察者2
 */
class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应");
    }
}