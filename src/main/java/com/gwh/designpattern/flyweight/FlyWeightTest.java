package com.gwh.designpattern.flyweight;

import java.util.HashMap;

/**
 * 享元模式
 * 把对象共同的部分给抽取出来共享使用，不同的部分给当作参数注入进去 节省系统的资源
 *
 * 应用场景
 * 系统中存在大量或相同相似的对象，这些对象消耗大量的内存资源
 */
public class FlyWeightTest {

    public static void main(String[] args) {
        //创建享元工厂
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        // 创建享元对象
        Flyweight a = flyweightFactory.getFlyweight("a");

        Flyweight a1 = flyweightFactory.getFlyweight("a");

        Flyweight a2 = flyweightFactory.getFlyweight("a");

        Flyweight b = flyweightFactory.getFlyweight("b");
        Flyweight b1 = flyweightFactory.getFlyweight("b");

       a.operation(new UnsharedConcreteFlyweight("第一次调用a"));
       a1.operation(new UnsharedConcreteFlyweight("第二次调用a"));
       a2.operation(new UnsharedConcreteFlyweight("第三次调用a"));
       b.operation(new UnsharedConcreteFlyweight("第一次调用b"));
       b1.operation(new UnsharedConcreteFlyweight("第二次调用b"));


    }
}

/**
 * 非享元角色
 * 不同的部分
 */
class UnsharedConcreteFlyweight{

    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

/**
 * 抽象享元角色 非享元角色作为参数注入到享元角色中
 */
interface Flyweight{
    public void operation(UnsharedConcreteFlyweight param);
}

/**
 * 具体享元角色 共有的享元角色
 */
class ConcreteFlyweight implements Flyweight{

    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元"+key+"被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight param) {
        System.out.println("具体享元"+key+"被调用！");
        System.out.println("非享元信息是："+param.getInfo());
    }
}

/**
 * 享元工厂角色 创建一个一个的享元对象
 */
class FlyweightFactory{

    private HashMap<String,Flyweight> flyweightHashMap=new HashMap<String,Flyweight>();

    public Flyweight getFlyweight(String key){

        Flyweight flyweight = (Flyweight)flyweightHashMap.get(key);

        if(flyweight == null){
            flyweight = new ConcreteFlyweight(key);
            flyweightHashMap.put(key,flyweight);
        }else {
            System.out.println("具体享元"+key+"已经存在，被成功获取！");
        }
        return flyweight;
    }

}

