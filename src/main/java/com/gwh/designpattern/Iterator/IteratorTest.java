package com.gwh.designpattern.Iterator;


import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * 应用场景
 * 1.当需要为聚合对象提供多种遍历方式时
 * 2.当需要为遍历不同的聚合结构提供一个统一的接口时
 * 3.当访问一个聚合对象的内容而无需暴露其内部细节表示时
 *
 */
public class IteratorTest {

    public static void main(String[] args) {
        Aggreate ag = new ConcreteAggregate();
        ag.add("湖南大学");
        ag.add("北京大学");
        ag.add("河南大学");
        System.out.println("聚合对象的内容：");
        Iterator it = ag.getIterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o.toString()+"         ");
        }
        Object first = it.first();
        System.out.println("\nFirst:"+first.toString());

    }

}

/**
 * 抽象聚合
 */
interface Aggreate{

    // 添加一个迭代器
    public void add(Object obj);
    // 删除一个迭代器
    public void remove(Object obj);
    // 返回具体迭代器对象
    public Iterator getIterator();

}

/**
 * 具体聚合
 */
class ConcreteAggregate implements Aggreate{

   private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}


/**
 * 抽象迭代器
 */
interface Iterator{

    Object first();

    Object next();

    boolean hasNext();

}

/**
 * 具体迭代器
 */
class ConcreteIterator implements Iterator{

    private List<Object> list = null;

    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    /**
     * 获取第一个元素
     * @return
     */
    @Override
    public Object first() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }

    /**
     * 获取下一个元素
     * @return
     */
    @Override
    public Object next() {
        Object obj = null;
        if(this.hasNext()){
            obj = list.get(++index);
        }
        return obj;
    }

    /**
     * 判断是否有元素
     * @return
     */
    @Override
    public boolean hasNext() {
        // 当前索引小于最后一个
        if(index < list.size() -1){
            return true;
        }
        return false;
    }
}