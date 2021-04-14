package com.gwh.designpattern.duty;

/**
 * 职责链模式
 * 应用场景
 * 1.有多个对象可以处理一个请求，哪个对象处理该请求由运行时刻自动确定
 * 2.可动态指定一组对象处理请求，或添加新当处理者
 * 3.在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求
 *
 */
public class DutyTest {

    public static void main(String[] args) {
        // 组装责任链
        Handler handler1 = new ConcreHandler1();
        Handler handler2 = new ConcreHandler2();
        handler1.setNext(handler2);
        // 提交请求
        handler1.handleRequest("one");

    }


}

/**
 * 抽象处理者角色
 */
abstract class Handler{

    // 下一个请求
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }
    // 处理请求的方法
    public abstract void handleRequest(String request);

}

/**
 * 具体处理者1
 */
class ConcreHandler1 extends Handler{

    @Override
    public void handleRequest(String request) {
        if(request.equals("one")){
            System.out.println("具体处理者1负责处理该请求！");
        }else {
            if(getNext()!=null){
                getNext().handleRequest(request);
            }else {
                System.out.println("没有处理该请求");
            }
        }

    }
}

/**
 * 具体处理者2
 */
class ConcreHandler2 extends Handler{

    @Override
    public void handleRequest(String request) {
        if(request.equals("two")){
            System.out.println("具体处理者2负责处理该请求！");
        }else {
            if(getNext()!=null){
                getNext().handleRequest(request);
            }else {
                System.out.println("没有处理该请求");
            }
        }

    }
}



