package cn.kahun.design.patterns.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @create: 2019-06-17 23:20
 * @author: prague
 * @description:
 **/
public class JdkMatchMaker implements InvocationHandler {

  private Object target;


  @SuppressWarnings("unchecked")
  public <T> T getInstance(Object target){

    this.target = target;
    return (T) Proxy
        .newProxyInstance(this.target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    before();
    Object o = method.invoke(this.target, args);
    after();

    return o;
  }

  private void before() {

    System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
    System.out.println("开始物色");
  }

  private void after() {

    System.out.println("OK的话，准备办事");
  }
}
