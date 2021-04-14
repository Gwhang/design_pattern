package com.gwh.designpattern.bridging;

/**
 * 桥接模式
 * 即实现了本身的功能，又实现了具体接口的功能
 */
public class BridgeTest {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction=new RefineAbstraction(implementor);
        abstraction.operation();
    }

}

/**
 * 实现化角色
 */
interface Implementor{
    public void OperationImpl();
}

/**
 * 具体实现化角色
 */
class ConcreteImplementorA implements Implementor{
    @Override
    public void OperationImpl() {
        System.out.println("具体实现化角色 ConcreteImplementorA 被访问");
    }
}
/**
 * 具体实现化角色
 */
class ConcreteImplementorB implements Implementor{
    @Override
    public void OperationImpl() {
        System.out.println("具体实现化角色 ConcreteImplementorB 被访问");
    }
}

/**
 * 抽象化角色
 */
abstract class Abstraction{

    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public  abstract void operation();
}

/**
 * 扩展抽像化角色
 */
class RefineAbstraction extends Abstraction{

    protected RefineAbstraction(Implementor implementor) {
        super(implementor);
    }
    @Override
    public void operation() {
        System.out.println("扩展抽象化角色RefineAbstraction  被访问");
        implementor.OperationImpl();
    }


}