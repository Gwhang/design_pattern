package com.gwh.designpattern.compose;

import java.util.ArrayList;

/**
 * 安全式组合模式
 * 使用场景
 * 1.在需要表示一个对象整体与部分的层次结构的场合
 * 2.要求对用户隐藏组合对象与单个对象的不同，用户可以用统一的接口使用组合结构中的所有对象场合
 *
 */
public class SafeCompositePattern {

    public static void main(String[] args) {

        SafeComposite c1 = new SafeComposite();
        SafeComposite c2 = new SafeComposite();

        SafeLeaf leaf1 = new SafeLeaf("1");
        SafeLeaf leaf2 = new SafeLeaf("2");
        SafeLeaf leaf3 = new SafeLeaf("3");

        c1.add(leaf1);
        c1.add(c2);
        c2.add(leaf2);
        c2.add(leaf3);
        c1.operation();

    }

}

/**
 * 抽象构件
 */
interface SafeComponent{
    public void operation();
}

/**
 * 树叶构件
 */
class SafeLeaf implements SafeComponent{

    private String name;

    public SafeLeaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("树叶"+name+"被访问！");
    }
}

/**
 * 树枝构件
 */
class SafeComposite implements SafeComponent{

    private ArrayList<SafeComponent> childre = new ArrayList<SafeComponent>();

    public void add(SafeComponent component) {
        childre.add(component);
    }


    public void remove(SafeComponent component) {
        childre.remove(component);
    }

    public SafeComponent getChild(int i) {
        return childre.get(i);
    }

    @Override
    public void operation() {
        for (Object obj:childre){
            ((SafeComponent)obj).operation();
        }
    }
}