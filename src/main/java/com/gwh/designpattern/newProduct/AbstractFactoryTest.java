package com.gwh.designpattern.newProduct;

/**
 * 工厂模式
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        // new 具体工厂抽象类 得到实际的工厂对象
        AbstractFactory abstractFactory=new ConcreteFactory1();
        // 创建具体的产品
        Product product = abstractFactory.newProduct();
        product.show();
    }

}

// 定义抽象产品
interface Product{
    public void show();
}
// 具体产品实现
class concreteProduct1 implements Product{
    @Override
    public void show() {
        System.out.println("具体产品1.。。。");
    }
}

class concreteProduct2 implements Product{
    @Override
    public void show() {
        System.out.println("具体产品2.。。。");
    }
}

// 抽象工厂
interface AbstractFactory{
    public Product newProduct();
}
// 具体工厂实现
class ConcreteFactory1 implements AbstractFactory{

    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成 ->具体产品1");
        return new concreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory{

    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成 ->具体产品2");
        return new concreteProduct2();
    }
}