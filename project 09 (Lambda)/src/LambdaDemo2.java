public class LambdaDemo2 {
    //静态方法
    //场景：猫和狗都可以参加游泳比赛
    public static void go(Swimming s) {
        System.out.println("开始！");
        s.swim();
    }
    //静态抽象内部类
    public static abstract class Animal {
        //抽象方法
        public abstract void cry();
    }

    public static void main(String[] args) {
        //----------------------------------------
        //匿名内部类
        Swimming s1 = new Swimming() {
            @Override
            public void swim() {
                System.out.println("猫游泳贼快~");
            }
        };
        go(s1);
        //Lambda 表达式
        Swimming s2 = () -> System.out.println("猫游泳贼快~");
        go(s2);
        System.out.println("");

        //----------------------------------------

        //匿名内部类
        go(new Swimming() {
            @Override
            public void swim() {
                System.out.println("狗游泳贼溜~");
            }
        });
        //Lambda 表达式
        go(() -> System.out.println("狗游泳贼溜~"));
        System.out.println("");

        //----------------------------------------

        //匿名内部类
        Animal a1 = new Animal() {
            //方法实现
            @Override
            public void cry() {
                System.out.println("狗汪汪汪的叫~");
            }
        };
        a1.cry();
        /*//Lambda 表达式
        Animal a2 = () -> System.out.println("狗汪汪汪的叫~");//错误*/

        //Lambda 表达式只能替代函数式接口的匿名内部类对象！！！
    }
}

/*Q1：什么是函数式编程？有何好处？
      一种编程范式，将函数视为对象，可作为参数、或返回值，甚至用变量记住
      程序代码更简洁，可读性更好
  Q2：Lambda 表达式是啥？有什么用？怎么写？
      JDK 8 新增的一种语法，代表函数
      可以用于替代并简化函数式接口的匿名内部类
      (被重写方法的形参) -> {被重写方法的方法体}
  Q3：什么样的接口式函数式接口？怎么确保一个接口式函数式接口？
     只有一个抽象方法的接口式函数式接口
     在接口上加上 @FuncationalInterface 注解即可*/
