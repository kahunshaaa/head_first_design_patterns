package cn.kahun.design.patterns.factory.abstractFactory;

import cn.kahun.design.patterns.factory.Pizza;

/**
 * @create: 2019-03-14 19:42
 * @author: prague
 * @description: 披萨抽象工厂
 **/
public abstract class AbstractPizzaStore {

    public Pizza orderPizza(String type){

        Pizza pizza = createPizza(type);

        pizza.prepare();

        pizza.bake();

        pizza.cut();

        pizza.box();

        return pizza;

    }

    /**
     * 抽象创建披萨方法
     * @param type 类型
     * @return 披萨
     */
    abstract Pizza createPizza(String type);

}
