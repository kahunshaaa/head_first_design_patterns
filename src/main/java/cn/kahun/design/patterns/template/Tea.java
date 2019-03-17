package cn.kahun.design.patterns.template;

public class Tea extends AbstractCaffeineBeverage {

    @Override
    void brew() {

        System.out.println("brew tea bag");
    }

    @Override
    void addCondiments() {

        System.out.println("add lemon");
    }
}
