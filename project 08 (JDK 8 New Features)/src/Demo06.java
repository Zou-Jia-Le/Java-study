import java.util.ArrayList;

/**
 * list 中间操作:
 * 1、filter 过滤
 * 2、limit 限制
 * 3、skip 跳过
 * 4、distinct 去重复
 * 5、sorted 排序
 * 6、map 映射
 * 7、parallelStream 采用多线程（效率高）
 */
public class Demo06 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList();
        list.add(new Employee("小王",15000));
        list.add(new Employee("小张",12000));
        list.add(new Employee("小李",18000));
        list.add(new Employee("小孙",20000));
        list.add(new Employee("小刘",25000));
        //list.add(new Employee("小刘",25000));

        //1、filter 过滤
        list.stream()
                .filter(e -> e.getMoney() > 15000)
                .forEach(System.out::println);
        System.out.println("");

        //2、limit 限制
        list.stream()
                .limit(2)
                .forEach(System.out::println);
        System.out.println("");

        //3、skip 跳过
        list.stream()
                .skip(2)
                .forEach(System.out::println);
        System.out.println("");

        //4、distinct 去重复
        list.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println("");

        //5、sorted 排序
        list.stream()
                .sorted((e1,e2) -> Double.compare(e1.getMoney(),e2.getMoney()))
                .forEach(System.out::println);
        System.out.println("");

        //6、map 映射
        list.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);
        System.out.println("");

        //7、parallelStream 采用多线程（效率高）
        list.parallelStream()
                .forEach(System.out::println);
    }
}
