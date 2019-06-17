package cn.kahun.design.patterns.proxy.dynamic.jdk;

import cn.kahun.design.patterns.proxy.Person;

/**
 * @create: 2019-06-17 23:27
 * @author: prague
 * @description:
 **/
public class JdkProxyTest {

  public static void main(String[] args) {

    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    Person person  = new JdkMatchMaker().getInstance(new Girl());

    person.findLove();

  }

}
