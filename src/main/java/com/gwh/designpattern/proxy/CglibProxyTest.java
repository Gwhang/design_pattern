package com.gwh.designpattern.proxy;

/**
 * Cglib实现动态代理
 * 前提条件
 * 1.引入Cglib的jar 包文件 cglib-nodep-3.2.6.jar
 * 2.目标类不能为 final
 * 3.目标对象方法如果为final static 那么就不会被拦截，就不会执行目标对象额外的业务方法
 *
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        // 目标对象
        CglibSinger cglibSinger = new CglibSinger();
        // 代理对象
        CglibSinger proxy =(CglibSinger) new CglibProxyFactory(cglibSinger).getProxyInstance();
        // 执行代理对象的方法
        proxy.Sing();
    }
}

/**
 * 目标对象 没有实现任何接口
 */
class CglibSinger{

    public void Sing(){
        System.out.println("唱一首歌");
    }
}