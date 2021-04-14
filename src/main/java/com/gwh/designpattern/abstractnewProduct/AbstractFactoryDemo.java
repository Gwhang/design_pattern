package com.gwh.designpattern.abstractnewProduct;

/**
 * 抽象工厂类
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        // 生产抽象工厂的具体对象
        AbstractFactory af = new ConcreteFactory1();
        // 用具体工厂生产产品
        Product1 product1 = af.newProduct1();
        Product2 product2 = af.newProduct2();
        // 调用产品展示方法
        product1.show();
        product2.show();

    }


}

/**
 * 产品1
 */
interface Product1{
    void show();
}
/**
 * 产品2
 */
interface Product2{
    void show();
}
/**
 * 具体产品1
 */
class ConcreteProduct11 implements Product1{
    @Override
    public void show() {
        System.out.println("显示工厂1生产的产品1");
    }
}
/**
 * 具体产品2
 */
class ConcreteProduct12 implements Product1{
    @Override
    public void show() {
        System.out.println("显示工厂2生产的产品1");
    }
}

/**
 * 具体产品1
 */
class ConcreteProduct21 implements Product2{
    @Override
    public void show() {
        System.out.println("显示工厂1生产的产品2");
    }
}
/**
 * 具体产品2
 */
class ConcreteProduct22 implements Product2{
    @Override
    public void show() {
        System.out.println("显示工厂2生产的产品2");
    }
}

/**
 * 抽象工厂接口
 */
interface AbstractFactory{
    public Product1 newProduct1();
    public Product2 newProduct2();

}

/**
 * 具体工厂1
 */
class ConcreteFactory1 implements AbstractFactory{
    @Override
    public Product1 newProduct1() {
        System.out.println("工厂1生产产品1");
        return new ConcreteProduct11();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("工厂1生产产品2");
        return new ConcreteProduct21();
    }
}
/**
 * 具体工厂2
 */
class ConcreteFactory2 implements AbstractFactory{
    @Override
    public Product1 newProduct1() {
        System.out.println("工厂2生产产品1");
        return new ConcreteProduct12();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("工厂2生产产品2");
        return new ConcreteProduct22();
    }
}
