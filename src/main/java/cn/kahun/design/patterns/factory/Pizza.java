package cn.kahun.design.patterns.factory;

import lombok.Data;

/**
 * @create: 2019-03-13 23:05
 * @author: prague
 * @description: 披萨统一接口，所有披萨都需要实现该接口
 **/
@Data
public abstract class Pizza {

    private String name;
    private String dough;
    private String sauce;

    /**
     * 准备
     */
    public void prepare(){

        System.out.println("prepare "+name+" for 15 minutes");
    }

    /**
     * 烘烤
     */
    public void bake(){

        System.out.println("bake for 25 minutes at 350");
    }

    /**
     * 切片
     */
    public void cut(){

        System.out.println("cutting the pizza into diagonal slices");
    }

    /**
     * 装箱
     */
    public void box(){

        System.out.println("place pizza in official pizza store box");
    }

}
