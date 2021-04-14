package com.gwh.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理类
 */
public class CglibProxyFactory implements MethodInterceptor {

    //维护目标对象
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     * @return
     */
    public Object getProxyInstance(){
        // 1.工具类
        Enhancer en = new Enhancer();
        // 2.设置父类
        en.setSuperclass(target.getClass());
        // 3.设置回调函数
        en.setCallback(this);
        // 4.创建子类代理对象
        return en.create();
    }

    /**
     * 定义拦截器：在调用目标方法时，CGlib会回调MethodInterceptor接口方法来进行拦截
     * 来实现你自己的代理逻辑，类似于JDK中的InvocationHandler 接口
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("向观众问好");
        // 执行目标对象的方法
        Object invoke = method.invoke(target, objects);
        System.out.println("谢谢大家");
        return invoke;
    }
}
