package com.gwh.designpattern.ornament;

/**
 * 装饰者模式
 */
public class OrnamentTest {

    public static void main(String[] args) {
        // 创建具体构件角色
        Component component=new ConcreteComponent();
        //  创建具体装饰角色
        Component component1 = new ConcreteDecorator(component);
        // 调用具体装饰角色的功能，实际上中间访问了具体构件角色的功能
        component1.operation();
    }

}

/**
 * 抽象构建角色
 */
interface Component{
    void operation();
}

/**
 * 具体构建化角色
 */
class ConcreteComponent implements Component{
    public ConcreteComponent() {
        System.out.println("创建具体构建角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation");
    }
}

/**
 * 抽象装饰角色
 */
class Decorator implements Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}

/**
 * 具体装饰角色
 */
class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction(){
        System.out.println("为具体构件角色增加额外的功能addFunction");
    }

}
