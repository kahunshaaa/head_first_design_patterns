package cn.kahun.design.patterns.proxy.dynamic.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @create: 2019-06-18 00:41
 * @author: prague
 * @description:
 **/
public class CglibMatchMaker implements MethodInterceptor {

  public Object getInstance(Class<?> clazz) {

    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);

    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {

    before();

    Object object = methodProxy.invokeSuper(o,objects);

    after();

    return object;
  }

  private void before() {

    System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
    System.out.println("开始物色");
  }

  private void after() {

    System.out.println("OK的话，准备办事");
  }
}
