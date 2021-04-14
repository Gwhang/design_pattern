package com.gwh.designpattern.compose;

import java.util.ArrayList;

/**
 * 透明式组合模式
 */
public class CompositePattern {

    public static void main(String[] args) {
          // 创建树枝对象
          Component c0= new Composite();
          Component c1= new Composite();
          // 创建树叶对象
          Component leaf1 = new Leaf("1");
          Component leaf2 = new Leaf("2");
          Component leaf3 = new Leaf("3");

          c0.add(leaf1);
          c0.add(c1);
          c1.add(leaf2);
          c1.add(leaf3);
          c0.operation();


    }
}

/**
 * 抽象构件
 */
interface Component{
    public void add(Component component);

    public void remove(Component component);

    public Component getChild(int i);

    public void operation();

}

/**
 * 树叶构件
 */
class Leaf implements Component{

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶"+name+"被访问！");
    }
}

/**
 * 树枝构件
 */
class Composite implements Component{

    private ArrayList<Component> childre = new ArrayList<Component>();

    @Override
    public void add(Component component) {
        childre.add(component);
    }

    @Override
    public void remove(Component component) {
        childre.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return childre.get(i);
    }

    /**
     * 遍历所有子方法执行所有子方法的operation 方法
     */
    @Override
    public void operation() {
        for (Object obj:childre){
            ((Component)obj).operation();
        }
    }
}
