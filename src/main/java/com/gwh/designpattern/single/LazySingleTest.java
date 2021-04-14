package com.gwh.designpattern.single;


/**
 * 懒汉式单例模式
 *  当需要的时候才会创建
 */
public class LazySingleTest {

    private static volatile LazySingleTest instance = null;

    // 避免类被外部方法实例化
    private LazySingleTest(){
        System.out.println("创建懒汉单例模式对象");
    }

    // 获取单例类方法
    public static synchronized LazySingleTest getInstance(){
        if(instance == null){
            instance = new LazySingleTest();
        }
        return instance;
    }

}
