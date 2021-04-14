package com.gwh.designpattern.appearance;

/**
 * 外观模式
 */
public class FacadeTest {

    public static void main(String[] args) {
        Facade facade= new Facade();
        facade.method();

    }

}

/**
 * 外观角色
 *  当调用外观角色的时候，创建外观子角色，然后执行其方法
 *
 */
class Facade{

    private SubSystem01 obj1= new SubSystem01();
    private SubSystem02 obj2= new SubSystem02();
    private SubSystem03 obj3= new SubSystem03();

    public void method(){
        obj1.method1();
        obj2.method1();
        obj3.method1();

    }

}

/**
 * 子系统01
 */
class SubSystem01{
    public void method1(){
        System.out.println("子系统01方法被调用");
    }
}
/**
 * 子系统02
 */
class SubSystem02{
    public void method1(){
        System.out.println("子系统02方法被调用");
    }
}
/**
 * 子系统03
 */
class SubSystem03{
    public void method1(){
        System.out.println("子系统03方法被调用");
    }
}