package cn.kahun.design.patterns.proxy.dynamic.jdk;

import cn.kahun.design.patterns.proxy.Person;

/**
 * @create: 2019-06-17 23:18
 * @author: prague
 * @description:
 **/
public class Girl implements Person {

  @Override
  public void findLove() {
    System.out.println("高");
    System.out.println("富");
    System.out.println("帅");
  }
}
