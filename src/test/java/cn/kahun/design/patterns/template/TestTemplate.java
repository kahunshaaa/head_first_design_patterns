package cn.kahun.design.patterns.template;

import cn.kahun.design.patterns.template.compare.Duck;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TestTemplate {

    @Test
    public void testTemplate(){

        AbstractCaffeineBeverage coffee = new Coffee();

        coffee.prepareRecipe();

        System.out.println("============");
        System.out.println("============");
        System.out.println("============");

        AbstractCaffeineBeverage tea = new Tea();

        tea.prepareRecipe();

    }

    @Test
    public void testSort(){

        Duck[] ducks = {

            new Duck("Daffy",3),
                new Duck("Dewey",2),
                new Duck("Howard",8),
                new Duck("Donald",7),
                new Duck("Huey",10)

        };

        Arrays.sort(ducks);

        System.out.println(Arrays.toString(ducks));

    }

}
