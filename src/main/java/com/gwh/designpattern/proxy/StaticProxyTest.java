package com.gwh.designpattern.proxy;

/**
 * 静态代理
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        // 代理对象必须提前写出，如果接口层发生变化，代理对象代码也要进行维护
        // 创建真实对象
        SingerSubject singerSubject = new SingerSubject();
        // 调用代理方法
        SingerProxt singerProxt = new SingerProxt(singerSubject);
        singerProxt.Sing();
    }

}

/**
 * 抽象主题对象
 */
interface Singer{
    void Sing();
}

/**
 * 真实主题对象
 */
class SingerSubject implements Singer{
    @Override
    public void Sing() {
        System.out.println("唱一首歌曲");
    }
}

/**
 * 代理类
 */
class SingerProxt implements Singer{

    private SingerSubject singerSubject;

    public SingerProxt(SingerSubject singerSubject) {
        this.singerSubject = singerSubject;
    }

    @Override
    public void Sing() {
        System.out.println("大家好");
        singerSubject.Sing();
        System.out.println("谢谢大家");
    }
}