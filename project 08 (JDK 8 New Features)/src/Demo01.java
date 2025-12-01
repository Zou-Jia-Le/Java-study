import java.util.Comparator;
import java.util.TreeSet;

/**
 * Lambda 表达式的使用
 */
public class Demo01 {
    public static void main(String[] args) {
        //-----------------------------------------------------------------
        //匿名内部类
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程1执行了......");
            }
        };
        new Thread(runnable1).start();

        //Lambda 表达式：删右边；删形参类型；方法内只有一行的话，还可以删{}（有返回值还要删 return）
        Runnable runnable2 = () -> System.out.println("子线程2执行了......");
        new Thread(runnable2).start();
        new Thread(() -> System.out.println("子线程3执行了......")).start();

        //-----------------------------------------------------------------

        //匿名内部类
        Comparator<String> com1 = new Comparator<String>() {
            @Override
            public int compare (String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        TreeSet<String> treeSet = new TreeSet<>(com1);

        //Lambda 表达式：删右边
        Comparator<String> com2 = (String o1, String o2) -> {
            return o1.length() - o2.length();
        };
        TreeSet<String> treeSet2 = new TreeSet<>(com2);

        //Lambda 表达式：删右边、删形参类型；方法内只有一行的话，还可以删{}（有返回值还要删 return）
        Comparator<String> com3 = (o1,o2) -> o1.length() - o2.length();
        TreeSet<String> treeSet3 = new TreeSet<>(com3);
        //-----------------------------------------------------------------
    }
}

//Lambda 表达式：特殊的匿名内部类，语法更简洁
//Lambda 表达式允许把函数作为一个方法的参数(函数作为方法参数传递)，将代码像数据一样传递

/*基本语法：
    <函数式接口> <变量名> = (参数1，参数2...) -> {
        方法体
    };
  .Lambda 引入了新的操作符：->(箭头操作符)，-> 将表达式分成两部分
    左侧：(参数1，参数2…)表示参数列表
    右侧：{}内部是方法体*/

/*注意事项:
    1、形参列表的数据类型会自动推断
    2、如果形参列表为空，只需保留()
    3、如果形参只有1个，()可以省略，只需要参数的名称即可
    4、如果执行语句只有一句，且无返回值，{}可以省略；若有返回值，则若想省去{}，则必须同时省略 return，且执行语句也保证只有一句
    5、Lambda 表达式 不会生成一个单独的内部类文件*/
