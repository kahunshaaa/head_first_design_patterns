package cn.kahun.design.patterns.factory.simple.factory;

import cn.kahun.design.patterns.factory.CheesePizza;
import cn.kahun.design.patterns.factory.PepperoniPizza;
import cn.kahun.design.patterns.factory.Pizza;
import cn.kahun.design.patterns.factory.VeggiePizza;

/**
 * @create: 2019-03-13 23:48
 * @author: prague
 * @description: 简单工厂
 **/
public class SimplePizzaFactory {

    public Pizza createPizza(String type){

        Pizza pizza = null;

        if ("cheese".equals(type)){

            pizza = new CheesePizza();

        }else if ("veggie".equals(type)){

            pizza = new VeggiePizza();

        }else{

            pizza = new PepperoniPizza();
        }

        return pizza;

    }

}
