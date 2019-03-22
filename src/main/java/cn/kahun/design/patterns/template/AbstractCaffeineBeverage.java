package cn.kahun.design.patterns.template;

public abstract class AbstractCaffeineBeverage {

    final void prepareRecipe(){

        boilWater();

        brew();

        addCondiments();

        pourInCup();

    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){

        System.out.println("boil water");
    }

    void pourInCup(){

        System.out.println("pour into cup");
    }
}
