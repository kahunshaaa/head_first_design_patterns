package cn.kahun.design.patterns.proxy.dynamic.cglib;

/**
 * @create: 2019-06-18 00:46
 * @author: prague
 * @description:
 **/
public class CglibTest {

  public static void main(String[] args) {

    Boy boy = (Boy) new CglibMatchMaker().getInstance(Boy.class);

    boy.findLove();


  }

}
