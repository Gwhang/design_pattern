package com.gwh.designpattern.prototype;

/**
 * 原型模式测试
 */
public class ProtoType {

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizetType realizetType1= new RealizetType();
        realizetType1.setName("张三");
        RealizetType realizetType2 = realizetType1.clone();
        if(realizetType1 == realizetType2){
            System.out.println("对象是同一个");
        }else {
            System.out.println("对象不是同一个");
        }
        System.out.println(realizetType1.toString());
        System.out.println(realizetType2.toString());

    }

}
