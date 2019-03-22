# 工厂模式 烘烤OO的精华

>披萨商店类

```
public class PizzaStore {
   
       Pizza orderPizza(String type){
   
           Pizza pizza;
   
           if ("cheese".equals(type)){
   
               pizza = new CheesePizza();
   
           }else if ("veggie".equals(type)){
   
               pizza = new VeggiePizza();
   
           }else{
   
               pizza = new PepperoniPizza();
           }
   
           pizza.prepare();
   
           pizza.bake();
   
           pizza.cut();
   
           pizza.box();
   
           return pizza;
   
       }
   }
```     

有一大堆具体实现类，我们通常会写出这样的代码。但是必须等到运行时，才知道该实例化哪一个。一旦有变化，就必须打开这段代码进行检查和修改。

从技术上说，new没有错，真正的问题源于改变。面向接口编程，可以隔离掉以后系统可能发生的一系列改变。所以要找
出变化的部分，把它从不变的部分里分离出来。

```
public class SimplePizzaStore {

    private SimplePizzaFactory simplePizzaFactory;

    public SimplePizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }
    
    public Pizza orderPizza(String type){
        
        Pizza pizza = simplePizzaFactory.createPizza(type);
        
        pizza.prepare();
        
        pizza.bake();
        
        pizza.cut();
        
        pizza.box();
        
        return pizza;
        
    }
}
```

简单工厂其实并不是一种设计模式，反而比较像是一种编程习惯。

披萨店经营有成，击败了其他竞争者。现在大家都希望披萨店能够在自家附近有加盟店。身为加盟公司的经营者，
你希望确保加盟店的运营质量，也想要提供不同风味的披萨来适应不同的地区。

所以修改披萨商店为超类，让每个区域类型继承这个超类，每个子类各自决定如何制造披萨

```
public abstract class AbstractPizzaStore {

    public Pizza orderPizza(String type){

        Pizza pizza = createPizza(type);

        pizza.prepare();

        pizza.bake();

        pizza.cut();

        pizza.box();

        return pizza;

    }

    /**
     * 抽象创建披萨方法
     * @param type 类型
     * @return 披萨
     */
    abstract Pizza createPizza(String type);

}



public class ChicagoPizzaStore extends AbstractPizzaStore{

    @Override
    Pizza createPizza(String type) {

        Pizza pizza = null;

        if ("cheese".equals(type)){

            pizza = new CheesePizza();

        }else if ("veggie".equals(type)){

            pizza = new VeggiePizza();

        }else if ("pepperoni".equals(type)){

            pizza = new PepperoniPizza();
        }

        return pizza;
    }
}
```

现在，orderPizza()对pizza做了许多事情，但由于pizza是抽象的，orderPizza()并不知道哪些实际
的具体类参与进来了。换句话说，这就是解藕

![图片alt](https://images2015.cnblogs.com/blog/1043545/201610/1043545-20161022125926420-94977749.png "工厂模式模型图")

**工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类**

>依赖倒置原则

当我们直接实例化一个对象的时候，就是在依赖它的具体类。在代码中减少对于具体类的依赖是一件好事。有一个设计模式就很好的阐明了这一点，依赖倒置原则（Dependency Inversion Principle）

这个原则说明了：不能让高层组件（PizzaStore）依赖底层组件（Pizza）；不管高层或者底层组件，都应该依赖于抽象而不是具体

依赖倒置原则中的倒置，指的是和一般OO设计的思考方式完全相反。低层组件依赖高层的抽象，同样，高层的组件也依赖相同的抽象，以下几条，可以帮助我们在OO设计中避免违反依赖倒置原则：

* 变量不可以持有具体类的引用
* 不要让类派生自具体类
* 不要覆盖基类中已实现的方法

现在披萨店的设计很棒，具有弹性的框架，而且遵循设计原则。但披萨店成功的关键在于新鲜、高质量的原料，通过导入新的框架，
加盟店将遵循你的流程，但是有一些加盟店，使用低价的原料来增加利润。你必须采取一些手段，以免长此以往毁了品牌。

##### 确保原料的一致性

对此，你打算建造一家生产原料的工厂，并将原料运送到各家加盟店。对于不同城市的原料的不同，准备不同组的原料。现在我们需要创建一个工厂来生产原料

```
public interface PizzaIngredientFactory {
    
    AbstractDough createDough();
    
    AbstractSauce createSauce();
    
    AbstractCheese createCheese();
    
    AbstractVeggies createVeggies();
}
```

我们引入了抽象工厂，来创建披萨原料工厂。通过抽象工厂所提供的接口，可以创建产品的家族。利用接口，我们的代码将从实际工厂解耦。

**抽象工厂模式提供了一个接口，用于创建相关或依赖对象的家族，而不需要明确的指定具体类**

>总结

***所有的工厂都是用来封装对象的创建***

***工厂方法使用继承，把对象的创建委托给子类，子类实现工厂方法来创建对象***

***抽象工厂使用对象组合，对象的创建被实现在工厂接口所暴露的方法中***

***所有工厂模式都是通过减少应用程序和具体类之间的依赖促进松耦合***


# 8 模板方法模式 封装算法  


>星巴兹咖啡冲泡法

1. 把水煮沸
2. 用沸水冲泡咖啡
3. 把咖啡倒进杯子里
4. 加糖和牛奶

>星巴兹茶冲泡法

1. 把水煮沸
2. 用沸水冲泡茶叶
3. 把咖啡倒进杯子里
4. 加柠檬

>咖啡和茶的冲泡代码第一版设计如下

```
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

   
   ```

**抽象重复的代码之后、改造之后**
 
```
public abstract class AbstractCaffeineBeverage {

    final void prepareRecipe(){
        
        boilWater();

        brew();

        addCondiments();

        pourInCup();

    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){

        System.out.println("boil water");
    }

    void pourInCup(){

        System.out.println("pour into cup");
    }
}


public class Tea extends AbstractCaffeineBeverage {

    @Override
    void brew() {

        System.out.println("brew tea bag");
    }

    @Override
    void addCondiments() {

        System.out.println("add lemon");
    }
}


public class Coffee extends AbstractCaffeineBeverage {

    @Override
    void brew() {

        System.out.println("brew coffee grinds");

    }

    @Override
    void addCondiments() {

        System.out.println("add sugar and milk");
    }
} 
```
 
>模版方法给我们什么

* 由抽象模版主导一切，它拥有算法，并保护这个算法。
* 对子类来说，抽象模版可以将代码的复用最大化。
* 算法只存在一个地方，容易修改。
* 抽象类专注于算法，而子类专注提供完整的实现。
* 新成员的加入，只需要实现自己的方法 
 
>定义模版方法模式

**模板方法模式**在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法的情况下，重新定义算法中的某些步骤

>模版中的Hook

在抽象类中使用抽象方法作为条件控制，来影响抽象类中的算法流程。

>好莱坞原则

别调用我们，我们会调用你。好莱坞原则可以给我们一种防止依赖腐败的方法。当高层组件依赖低层组件，而低层组件又依赖高层组件，高层组件又依赖边侧组件，边侧组件又依赖低层组件时，依赖腐败就发生了。
 
此时，允许低层组件使用挂钩（Hook）将自己挂钩到系统上，但是高层组件会决定什么时候和怎样去使用这些组件。就是高层组件对待低层组件的方式是“别调用我，我会调用你”
 

>要点

 * “模板方法”定义了算法的步骤，把这些步骤的实现延迟到了子类
 * 模板方法模式为我们提供了一种代码复用的重要技巧
 * 模版方法的抽象类可以定义抽象方法，具体方法和挂钩
 * Hook是一种方法，它只在抽象类中不做事，或者只做默认的事情，子类可以选择要不要覆盖它
 * 为了防止子类改变模板中的算法，可以将方法声明为final
 * 好莱坞原则告诉我们，将决策权放在高层模块中，以便决定如何以及何时调用低层模块
 * 策略和模板都封装算法，一个用组合，一个用抽象
 * 工厂方法是一种特殊的模板
 

# 迭代器与组合模式 管理良好的集合























 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 