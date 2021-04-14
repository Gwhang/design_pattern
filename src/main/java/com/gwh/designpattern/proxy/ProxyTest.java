package com.gwh.designpattern.proxy;

/**
 * 代理模式
 */
public class ProxyTest {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }

}

/**
 * 抽象主题
 */
interface Subject{
    void Request();
}

/**
 * 真实主题
 */
class RealSubject implements Subject{

    @Override
    public void Request() {
        System.out.println("访问真实主题的方法");
    }
}

/**
 * 代理对象
 */
class Proxy implements Subject{
    // 真实主题的成员变量
    private RealSubject realSubject;

    @Override
    public void Request() {
        // 成员变量为空重新创建一个
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        PostRequest();

    }

    /**
     * 方法执行前
     */
    public void preRequest(){
        System.out.println("访问真实主题之前的预处理");
    }

    /**
     * 方法执行后
     */
    public void PostRequest(){
        System.out.println("访问真实主题之后的预处理");
    }

}

