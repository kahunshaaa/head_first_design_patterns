package cn.kahun.design.patterns.factory.simple.factory;

import cn.kahun.design.patterns.factory.Pizza;

/**
 * @create: 2019-03-13 23:51
 * @author: prague
 * @description:
 **/
public class SimplePizzaStore {

    private SimplePizzaFactory simplePizzaFactory;

    public SimplePizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type){

        Pizza pizza = simplePizzaFactory.createPizza(type);

        pizza.prepare();

        pizza.bake();

        pizza.cut();

        pizza.box();

        return pizza;

    }
}
