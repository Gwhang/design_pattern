package com.gwh.designpattern.builder;

/**
 * 建造者客户端
 */
public class BuilderClient {

    public static void main(String[] args) {
        // 创建具体建造者对象
       Builder builder = new ConcreteBuilder1();
       // 创建指挥者对象
        Director director = new Director(builder);
        // 得到复杂产品对象
        Product construct = director.construct();
        // 得到复杂产品的具体展示方法
        construct.show();

    }

}
