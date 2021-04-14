package com.gwh.designpattern.builder;

/**
 * 具体建造者：实现抽象建造者接口
 */
public class ConcreteBuilder1 extends Builder{

    @Override
    public void buildPartA() {
        System.out.println("第一个具体建造者建造 PartA");
        product.setPartA("第一个具体建造者建造 PartA");
    }

    @Override
    public void buildPartB() {
        System.out.println("第一个具体建造者建造 PartB");
        product.setPartB("第一个具体建造者建造 PartB");
    }

    @Override
    public void buildPartC() {
        System.out.println("第一个具体建造者建造 PartC");
        product.setPartC("第一个具体建造者建造 PartC");
    }

}
