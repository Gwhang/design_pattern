package com.gwh.designpattern.newProduct;

/**
 * 简单工厂
 */
public class FactoryTest {

    public static void main(String[] args) {
        AnimalFactory af = Factory.getAnimalFactory(1);
        AnimalProduct animalProduct = af.newAnimalProduct();
        animalProduct.show();

    }

}

//定义抽象产品
interface AnimalProduct{
    void show();
}
//具体产品实现
class AnimalService1 implements AnimalProduct{
    @Override
    public void show() {
        System.out.println("小鸟生产成功");
    }
}
//具体产品实现
class AnimalService2 implements AnimalProduct{
    @Override
    public void show() {
        System.out.println("小狗生产成功");
    }
}
// 定义抽象工厂
interface AnimalFactory{
    AnimalProduct newAnimalProduct();
}
// 工厂实现类
class AnimalConcrete1 implements AnimalFactory{
    @Override
    public AnimalProduct newAnimalProduct() {
        System.out.println("生成小鸟的工厂");
        return new AnimalService1();
    }
}
// 工厂实现类
class AnimalConcrete2 implements AnimalFactory{
    @Override
    public AnimalProduct newAnimalProduct() {
        System.out.println("生成小狗的工厂");
        return new AnimalService2();
    }
}
class Factory{

    public static AnimalFactory getAnimalFactory(int a){
        switch (a){
            case 1:
                return new AnimalConcrete1();
            case 2:
                return new AnimalConcrete2();
        }
      return null;
    }

}