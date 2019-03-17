package cn.kahun.design.patterns.template.eden;

public class Tea {

    public void prepareRecipe(){

        boilWater();

        SteepTeaBag();

        pourInCup();

        addLemon();

    }

    public void boilWater(){

        System.out.println("boil water...");
    }

    public void SteepTeaBag(){

        System.out.println("brew tea bag");
    }

    public void pourInCup(){

        System.out.println("pouring into cup");
    }

    public void addLemon(){

        System.out.println("add lemon");
    }


}
