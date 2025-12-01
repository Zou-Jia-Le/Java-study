import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用：
 * 1、对象：：实例方法
 * 2、类：：静态方法
 * 3、类：：实例方法
 * 4、类：：new
 */
public class Demo04 {
    public static void main(String[] args) {
        //----------------------------------------------------------------------------------
        //1、对象：：实例方法(当 Lambda 表达式仅仅是在调用某个特定对象的实例方法时)
        //Lambda 表达式
        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("hello");

        //方法引用
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("world");

        System.out.println("");
        //----------------------------------------------------------------------------------

        //2、类：：静态方法(当 Lambda 表达式仅仅是在调用某个类的静态方法时)
        //Lambda 表达式
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(3, 2));

        //方法引用
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(1, 2));

        System.out.println("");
        //----------------------------------------------------------------------------------

        //3、类：：实例方法(当 Lambda 表达式的第一个参数是方法的调用者，其余参数是方法的参数时)
        //Lambda 表达式
        Function<Employee,String> function1 = e -> e.getName();
        System.out.println(function1.apply(new Employee("小明",25000)));

        //方法引用
        Function<Employee,String> function2 = Employee::getName;
        System.out.println(function2.apply(new Employee("小邹",50000)));

        System.out.println("");
        //----------------------------------------------------------------------------------

        //4、类：：new
        //Lambda 表达式(当 Lambda 表达式 仅仅是在创建某个类的对象时)
        Supplier<Employee> Supplier1 = () -> new Employee();
        Employee employee1 = Supplier1.get();
        System.out.println(employee1.toString());

        //方法引用
        Supplier<Employee> Supplier2 = Employee::new;
        Employee employee2 = Supplier2.get();
        System.out.println(employee2.toString());
        //----------------------------------------------------------------------------------
    }
}
