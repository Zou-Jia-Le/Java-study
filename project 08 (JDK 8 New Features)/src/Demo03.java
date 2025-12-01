import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常用的函数型接口：Consumer 消费型接口、Supplier 供给型接口、Function 函数型接口、Predicate 断言型接口
 */
public class Demo03 {
    //静态方法
    public static void happy(Consumer<Double> consumer,double money) {
        consumer.accept(money);
    }
    public static int[] getNums (Supplier<Integer> supplier,int count) {
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = supplier.get();
        }
        return nums;
    }
    public static String handlerString (Function<String,String> function,String str) {
        return function.apply(str);
    }
    public static List<String> filterNames(Predicate<String> predicate,List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (String string : list) {
            if (predicate.test(string)) {
                resultList.add(string);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        //-------------------------------------------------------------------------------------------------------
        //Consumer 消费型接口
        //匿名内部类
        Consumer<Double> consumer1 = new Consumer<Double>() {
            @Override
            public void accept(Double t) {
                System.out.println("聚餐消费：" + t);
            }
        };
        happy(consumer1,888);

        //Lambda 表达式
        Consumer<Double> consumer2 = t -> System.out.println("唱歌消费：" + t);
        happy(consumer2,1500);
        happy(t -> System.out.println("泡脚消费：" + t),3000);
        System.out.println("");

        //-------------------------------------------------------------------------------------------------------

        //Supplier 供给型接口
        //匿名内部类
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);//[0,10)
            }
        };
        System.out.println(Arrays.toString(getNums(supplier1,5)));

        //Lambda 表达式
        Supplier supplier2 = () -> new Random().nextInt(100);//[0,100)
        System.out.println(Arrays.toString(getNums(supplier2,15)));
        System.out.println(Arrays.toString(getNums(() -> new Random().nextInt(1000),25)));//[0,1000)
        System.out.println("");

        //-------------------------------------------------------------------------------------------------------

        //Function 函数型接口
        //匿名内部类
        Function<String,String> function1 = new Function<String,String>() {
            @Override
            public String apply(String s) {
                s.toUpperCase();
                return s;
            }
        };
        System.out.println(handlerString(function1,"hello"));

        //Lambda 表达式
        Function<String,String> function2 = s -> s.toUpperCase();
        System.out.println(handlerString(function2,"hello"));
        System.out.println(handlerString(s -> s.toLowerCase(),"hello"));
        System.out.println("");

        //-------------------------------------------------------------------------------------------------------

        //Predicate 断言型接口
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("张无忌");

        //匿名内部类
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.startsWith("张")) {
                    return true;
                } else
                    return false;
                }
        };
        System.out.println(filterNames(predicate1,list));

        //Lambda 表达式
        Predicate<String> predicate2 = s -> s.length() >= 3;
        System.out.println(filterNames(predicate2,list));
        System.out.println(filterNames(s -> s.length() >= 2,list));
        //-------------------------------------------------------------------------------------------------------
    }
}
