package com.gwh.designpattern.strategy;

/**
 * 策略模式
 * 应用场景
 * 1.一个系统需要动态的在几种算法中选择一种时，可将每个算法封装到策略类中
 * 2.一个类定义多种行为
 * 3.系统中各算法彼此独立，且要求对客户隐藏具体算法的实现细节
 *
 */
public class StrategyTest {

    public static void main(String[] args) {
        // 获取环境对象
        Context context=new Context();
        // 获取策略对象
        Strategy st = new ConcreteStrategyA();
        // 把策略对象传给环境对象的成员变量
        context.setStrategy(st);
        // 执行环境对象提供的对应方法
        context.strategyMethod();
        System.out.println(".................");


    }

}

/**
 * 抽象策略类
 */
interface Strategy{
    //策略方法
    public void strategyMethod();
}

/**
 * 具体策略类A
 */
class ConcreteStrategyA implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("具体策略类A的策略方法被访问");
    }
}

/**
 * 具体策略类B
 */
class ConcreteStrategyB implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("具体策略类B的策略方法被访问");
    }
}

/**
 * 环境类
 */
class Context{
    // 抽象策略类
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod(){
        strategy.strategyMethod();
    }


}
