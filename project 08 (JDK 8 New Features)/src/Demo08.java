import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 终止操作
 * 1、forEach 遍历
 * 2、min 最小值
 * 3、max 最大值
 * 4、count 统计元素个数
 * 5、reduce 规约
 * 6、collect 收集
 */
public class Demo08 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList();
        list.add(new Employee("小王",15000));
        list.add(new Employee("小张",12000));
        list.add(new Employee("小李",18000));
        list.add(new Employee("小孙",20000));
        list.add(new Employee("小刘",25000));

        //1、forEach 遍历
        list.stream()
                .filter(e ->
                    {System.out.println("执行过滤......");//没有终止操作不会执行
                    return e.getMoney() > 15000;})
                .forEach(System.out::println);
        System.out.println("");

        //2、min 最小值
        Optional<Employee> min = list.stream()
                .min((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(min.get());

        //3、max 最大值
        Optional<Employee> max = list.stream()
                .max((e1, e2) -> Double.compare(e1.getMoney(), e2.getMoney()));
        System.out.println(max.get());
        System.out.println("");

        //4、count 统计元素个数
        long count = list.stream()
                .count();
        System.out.println("员工个数：" + count);
        System.out.println("");

        //5、reduce 规约
        Optional<Double> sum = list.stream()
                .map(e -> e.getMoney())
                .reduce((x, y) -> x + y);//计算所有员工的工资和
        System.out.println(sum.get());
        System.out.println("");

        //6、collect 收集
        List<String> names = list.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());//获取所有的员工姓名，封装成一个 list 集合
        for (String name : names) {
            System.out.println(name);
        }
    }
}
