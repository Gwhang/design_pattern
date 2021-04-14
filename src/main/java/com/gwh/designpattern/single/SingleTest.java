package com.gwh.designpattern.single;

/**
 * 测试方法
 */
public class SingleTest {


    public static void main(String[] args) {
        // 懒汉式测试
        LazySingleTest lazySingleTest1=LazySingleTest.getInstance();
        LazySingleTest lazySingleTest2=LazySingleTest.getInstance();
        if(lazySingleTest1==lazySingleTest2){
            System.out.println("测试通过,对象是同一个");
        }else {
            System.out.println("测试不通过，不是同一个对象");
        }

        //饿汉式测试
        HungrySingleton hungrySingleton1=HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2=HungrySingleton.getInstance();

        if(hungrySingleton1==hungrySingleton2){
            System.out.println("测试通过,对象是同一个");
        }else {
            System.out.println("测试不通过，不是同一个对象");
        }
    }

}
