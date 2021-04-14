package com.gwh.designpattern.single;

/**
 * 饿汉单例模式
 * 该模式特点是类一旦加载就创建一个单例，保证在调用实例化方法前，单例已经存在
 */
public class HungrySingleton {

    private static final HungrySingleton instance=new HungrySingleton();

    private HungrySingleton(){
        System.out.println("创建饿汉单例模式对象");
    }
    // 获取实例方法
    public static HungrySingleton getInstance(){
        return instance;
    }

}
