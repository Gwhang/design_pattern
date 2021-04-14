package com.gwh.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理 JDK实现
 * 步骤很简单 直接调用Proxy类的静态方法 newProxyInstance即可，该方法会返回代理对象
 * static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 * 接收代理对象的参数
 * ClassLoader loader：指当前目标对象使用的类加载器
 * Class<?>[] interfaces 目标对象实现的接口类型
 * InvocationHandler h 事件处理接口，需要传入一个实现类，一般直接使用匿名内部类
 *
 */
public class DynamicProxyTest {


    public static void main(String[] args) {
        ISinger iSinger = new ISingerSubject();
        ISinger proxy = (ISinger)Proxy.newProxyInstance(iSinger.getClass().getClassLoader(),
                iSinger.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("向观众问好");
                        //执行目标对象方法
                        Object invoke = method.invoke(iSinger, args);
                        System.out.println("谢谢大家");
                        return invoke;
                    }
                });
        proxy.sing();
    }

}

/**
 * 抽象主题类
 */
interface ISinger{
    void sing();
}

/**
 * 真实主题类
 */
class ISingerSubject implements ISinger{
    @Override
    public void sing() {
        System.out.println("唱一首歌");
    }
}