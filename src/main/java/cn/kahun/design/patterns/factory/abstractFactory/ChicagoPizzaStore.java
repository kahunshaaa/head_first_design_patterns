package cn.kahun.design.patterns.factory.abstractFactory;

import cn.kahun.design.patterns.factory.CheesePizza;
import cn.kahun.design.patterns.factory.PepperoniPizza;
import cn.kahun.design.patterns.factory.Pizza;
import cn.kahun.design.patterns.factory.VeggiePizza;

/**
 * @create: 2019-03-14 21:51
 * @author: prague
 * @description:
 **/
public class ChicagoPizzaStore extends AbstractPizzaStore{

    @Override
    Pizza createPizza(String type) {

        Pizza pizza = null;

        if ("cheese".equals(type)){

            pizza = new CheesePizza();

        }else if ("veggie".equals(type)){

            pizza = new VeggiePizza();

        }else if ("pepperoni".equals(type)){

            pizza = new PepperoniPizza();
        }

        return pizza;
    }
}
