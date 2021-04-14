package com.gwh.designpattern.adapter;

/**
 * 对象适配器模式
 *
 * 与类适配器的区别是 不在继承适配者类 改用成员变量和有参构造函数的方式
 *
 */
public class ObjectAdapterTest {

    public static void main(String[] args) {
        System.out.println("对象适配器模式测试");
        ObjAdapter objAdapter = new ObjAdapter();
        ObjTarget objTarget= new ObjectAdapter(objAdapter);
        objTarget.request();


    }


}

/**
 * 目标接口
 */
interface ObjTarget{
    void request();
}

/**
 * 适配者类
 */
class ObjAdapter{

    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用");
    }
}

/**
 * 对象适配器类
 */
class ObjectAdapter implements ObjTarget{

    private ObjAdapter objAdapter;

    public ObjectAdapter(ObjAdapter objAdapter) {
        this.objAdapter = objAdapter;
    }

    @Override
    public void request() {
        objAdapter.specificRequest();
    }
}