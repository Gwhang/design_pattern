package com.gwh.designpattern.interpreter;

import java.util.HashSet;
import java.util.Set;

/**
 * 解释器模式
 * 根据文法规则按以下步骤设计公交车卡的读卡器程序的类图。
 * 定义一个抽象表达式（Expression）接口，它包含了解释方法 interpret(String info)。
 * 定义一个终结符表达式（Terminal Expression）类，它用集合（Set）类来保存满足条件的城市或人，并实现抽象表达式接口中的解释方法 interpret(Stringinfo)，用来判断被分析的字符串是否是集合中的终结符。
 * 定义一个非终结符表达式（AndExpressicm）类，它也是抽象表达式的子类，它包含满足条件的城市的终结符表达式对象和满足条件的人员的终结符表达式对象，并实现 interpret(String info) 方法，用来判断被分析的字符串是否是满足条件的城市中的满足条件的人员。
 * 最后，定义一个环境（Context）类，它包含解释器需要的数据，完成对终结符表达式的初始化，并定义一个方法 freeRide(String info) 调用表达式对象的解释方法来对被分析的字符串进行解释
 *
 * 应用场景：
 * 1.当语言的文法较为简单，且执行效率不是关键问题时。
 * 2.当问题重复出现，且可以用一种简单的语言来进行表达时。
 * 3.当一个语言需要解释执行，并且语言中的句子可以表示为一个抽象语法树的时候，如 XML 文档解释。
 *
 */
public class InterpreterTest {

    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }

}

//抽象表达式类
interface Expression {
    public boolean interpret(String info);
}

//终结符表达式类
class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<String>();
    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) set.add(data[i]);
    }
    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}
//非终结符表达式类
class AndExpression implements Expression {
    private Expression city = null;
    private Expression person = null;
    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}

//环境类
class Context {
    private String[] citys = {"韶关", "广州"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression cityPerson;
    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }
    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) System.out.println("您是" + info + "，您本次乘车免费！");
        else System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
    }
}