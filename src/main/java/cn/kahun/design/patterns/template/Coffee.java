package cn.kahun.design.patterns.template;

public class Coffee extends AbstractCaffeineBeverage {

    @Override
    void brew() {

        System.out.println("brew coffee grinds");

    }

    @Override
    void addCondiments() {

        System.out.println("add sugar and milk");
    }
}
