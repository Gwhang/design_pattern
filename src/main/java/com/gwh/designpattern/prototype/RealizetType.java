package com.gwh.designpattern.prototype;

/**
 * 原型模式实现
 * 浅克隆 实现 Cloneable 接口即可 调用 super.clone() 就实现了对象的克隆
 */
public class RealizetType implements Cloneable{

    private String name;

    RealizetType(){
        System.out.println("具体原型创建成功");
    }

    @Override
    public RealizetType clone() throws CloneNotSupportedException {
        System.out.println("克隆对象成功");
        return (RealizetType)super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RealizetType{" +
                "name='" + name + '\'' +
                '}';
    }
}
