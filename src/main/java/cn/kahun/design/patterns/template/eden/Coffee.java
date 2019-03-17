package cn.kahun.design.patterns.template.eden;

public class Coffee {

    public void prepareRecipe(){

        boilWater();

        brewCoffeeGrinds();

        pourInCup();

        addSugarAndMilk();

    }

    public void boilWater(){

        System.out.println("boil water...");
    }

    public void brewCoffeeGrinds(){

        System.out.println("brew coffee grinds");
    }

    public void pourInCup(){

        System.out.println("pouring into cup");
    }

    public void addSugarAndMilk(){

        System.out.println("add sugar and milk");
    }

}
