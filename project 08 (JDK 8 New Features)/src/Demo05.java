import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 怎么创建流对象？
 */
public class Demo05 {
    public static void main(String[] args) {
        //-----------------------------------------------------------------------------------------
        //1、Collection 对象中的 stream() 和 parallelStream() 方法
        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("apple");
        arraylist.add("huawei");
        arraylist.add("xiaomi");

        //创建流对象
        Stream<String> stream1 =  arraylist.stream();//执行方式：顺序执行
        //Stream<String> stream1 =  arraylist.parallelStream();执行方式：并行执行（多线程）

        //遍历打印
        stream1.forEach(System.out::println);
        System.out.println("");

        //-----------------------------------------------------------------------------------------

        //2、Arrays 工具类的 stream 方法
        String[] arr = new String[]{"aaa", "bbb", "ccc"};

        //创建流对象
        Stream<String> stream2 = Arrays.stream(arr);

        //遍历打印
        stream2.forEach(System.out::println);
        System.out.println("");

        //-----------------------------------------------------------------------------------------

        //3、Stream 接口中的 of、 iterate、 generate方法（使用 iterate 和 generate 方法创建流对象记得用 limit 中间操作限制一下流对象的数量，不然会无限生成）
        //创建流对象
        Stream<Integer> stream3 = Stream.of(10, 20, 30, 40, 50);
        //遍历打印
        stream3.forEach(System.out::println);
        System.out.println("===");

        //创建（迭代）流对象
        Stream<Integer> stream4 = Stream.iterate(0, i -> i + 2);//从 0 开始，每次递增 2
        //遍历打印
        stream4.limit(5).forEach(System.out::println);//limit 为中间操作，取前 5 个
        System.out.println("===");

        //创建（生成）流对象
        Stream<Integer> stream5 = Stream.generate(() -> new Random().nextInt(100));//[0,100)
        //遍历打印
        stream5.limit(5).forEach(System.out::println);//limit 为中间操作，取前 5 个
        System.out.println("===");

        //-----------------------------------------------------------------------------------------

        //4、IntStream、 LongStream、 DoubleStream 的 of、 range、 rangeClosed 方法
        //创建流对象
        IntStream stream6 = IntStream.of(100, 200, 300);
        //遍历打印
        stream6.forEach(System.out::println);
        System.out.println("===");

        //创建流对象
        IntStream stream7 = IntStream.range(0,5);//[0,50)
        //IntStream stream7 = IntStream.rangeClosed(0,5);//[0,50]
        //遍历打印
        stream7.forEach(System.out::println);
        //-----------------------------------------------------------------------------------------
    }
}
