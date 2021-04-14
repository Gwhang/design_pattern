package com.gwh.designpattern.template;

/**
 * 模板方法
 *  定义模板方法，通用的方法由抽象类实现，不同的方法有子类实现方法父类
 *
 *  应用场景
 *  1.算法的整体步骤固定，但是其中的个别部分容易变时，这时候可以使用模板方法模式，将容易变的部分抽象处理，供子类实现
 *  2.当需要控制子类的扩展时，模板方法只在特定点调用狗子操作，这样就只允许在这些点上进行扩展
 *  3.多个类据有公共的行为时
 *
 *
 */
public class TemplateMethodTest {

    public static void main(String[] args) {

        // 抽象类 new 一个子类对象 实现子类中的方法
        AbstractClass ab = new ConcreteClass();
        // 调用模板方法
        ab.TemplateMethod();

    }

}

/**
 * 抽象类
 */
abstract class AbstractClass{

    // 模板方法
    public void TemplateMethod(){
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    // 具体方法
    public void SpecificMethod(){
        System.out.println("抽象类中的具体方法被调用");
    }

    // 抽象方法1
    public abstract void abstractMethod1();
    // 抽象方法2
    public abstract void abstractMethod2();

}

/**
 * 具体子类
 */
class ConcreteClass extends AbstractClass{

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用");
    }
}