package cn.kahun.design.patterns.factory.factory.method;

import cn.kahun.design.patterns.factory.factory.method.ingredient.AbstractCheese;
import cn.kahun.design.patterns.factory.factory.method.ingredient.AbstractDough;
import cn.kahun.design.patterns.factory.factory.method.ingredient.AbstractSauce;
import cn.kahun.design.patterns.factory.factory.method.ingredient.AbstractVeggies;

/**
 * @create: 2019-03-14 22:51
 * @author: prague
 * @description: 披萨原料工厂
 **/
public interface PizzaIngredientFactory {

    AbstractDough createDough();

    AbstractSauce createSauce();

    AbstractCheese createCheese();

    AbstractVeggies createVeggies();
}
