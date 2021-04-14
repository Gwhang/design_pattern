package com.gwh.designpattern.adapter;

/**
 * 类适配者模式
 */
public class ClassAdapterTest {

    public static void main(String[] args) {
        System.out.println("类适配器模式测试");
        Target target = new ClassAdapter();
        target.request();
    }
}

/**
 * 目标接口
 */
interface Target{
    void request();
}

/**
 * 适配者类
 */
class Adapter{
    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用");
    }
}

/**
 * 类适配器类
 */
class ClassAdapter extends Adapter implements Target{

    @Override
    public void request() {
        //调用适配者代码
        specificRequest();
    }
}