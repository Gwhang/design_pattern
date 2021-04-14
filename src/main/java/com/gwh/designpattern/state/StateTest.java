package com.gwh.designpattern.state;

/**
 * 状态模式
 * 应用场景
 * 1.当一个对象的行为取决于它的状态的时候，并且它必须在运行时根据状态改变它的行为时，就可以考虑使用状态模式
 * 2.一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态时
 */
public class StateTest {

    public static void main(String[] args) {
        // 创建环境
        Context context = new Context();
        // 处理请求
        context.Handle();
        context.Handle();
        context.Handle();
    }

}

/**
 * 环境类
 */
class Context{

    private State state;

    // 定义初始化状态
    public  Context(){
        this.state =new ConcreteStateA();
    }
    // 读取状态
    public State getState() {
        return state;
    }
    // 设置状态
    public void setState(State state) {
        this.state = state;
    }
    // 对请求做处理
    public void Handle(){
        state.Handle(this);
    }

}


/**
 * 抽象状态类
 */
abstract class State{
    public abstract void Handle(Context context);
}

/**
 * 具体状态A类
 */
class ConcreteStateA extends State{

    @Override
    public void Handle(Context context) {
        System.out.println("当前状态是A");
        context.setState(new ConcreteStateB());
    }
}
/**
 * 具体状态B类
 */
class ConcreteStateB extends State{

    @Override
    public void Handle(Context context) {
        System.out.println("当前状态是B");
        context.setState(new ConcreteStateA());
    }
}