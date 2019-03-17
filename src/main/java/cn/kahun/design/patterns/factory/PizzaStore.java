package cn.kahun.design.patterns.factory;

import cn.kahun.design.patterns.factory.CheesePizza;
import cn.kahun.design.patterns.factory.PepperoniPizza;
import cn.kahun.design.patterns.factory.Pizza;
import cn.kahun.design.patterns.factory.VeggiePizza;

/**
 * @create: 2019-03-13 23:16
 * @author: prague
 * @description: 最原始的披萨店
 **/
public class PizzaStore {

    Pizza orderPizza(String type){

        Pizza pizza;

        if ("cheese".equals(type)){

            pizza = new CheesePizza();

        }else if ("veggie".equals(type)){

            pizza = new VeggiePizza();

        }else{

            pizza = new PepperoniPizza();
        }

        pizza.prepare();

        pizza.bake();

        pizza.cut();

        pizza.box();

        return pizza;

    }

}
