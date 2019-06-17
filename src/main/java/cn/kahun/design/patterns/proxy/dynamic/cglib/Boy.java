package cn.kahun.design.patterns.proxy.dynamic.cglib;

import cn.kahun.design.patterns.proxy.Person;

/**
 * @create: 2019-06-18 00:40
 * @author: prague
 * @description:
 **/
public class Boy implements Person {

  @Override
  public void findLove() {
    System.out.println("大");
    System.out.println("波");
    System.out.println("浪");
  }
}
