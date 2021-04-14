package com.gwh.designpattern.command;

/**
 * 命令模式
 *
 * 应用场景
 * 1.当系统需要请求调用者与请求接收者解耦时，命令模式使得调用者和接收者不直接交互
 * 2.当系统需要随机请求命令或经常增加或删除命令时，命令模式比较方便实现这些功能
 * 3.当系统需要执行一组操作时，命令模式可以定义宏命令来实现该功能
 *
 */
public class CommandTest {

    public static void main(String[] args) {
        // 创建要执行的命令
        Command cd = new ConcreteCommand();
        // 创建调用者
        Invoker iv = new Invoker(cd);
        System.out.println("客户端访问调用者 call方法");
        iv.call();
    }




}

/**
 * 调用者
 */
class Invoker{

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(){
        System.out.println("调用者执行命令 command。。。");
        //调用命令
        command.execute();
    }
}

// 抽象命令
interface Command{
    public abstract void execute();
}

/**
 * 具体命令
 */
class ConcreteCommand implements Command{

    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    // 执行命令 调用接收者方法
    @Override
    public void execute() {
        receiver.action();
    }
}

/**
 * 接收者
 */
class Receiver{

    public void action(){
        System.out.println("接收者的action方法被调用");
    }

}