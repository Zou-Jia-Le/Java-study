import java.util.ArrayList;
import java.util.UUID;

/**
 * 串行流和并行流的效率区别
 */
public class Demo07 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        //串行流
        long start1 = System.currentTimeMillis();
        long count1 = list.stream().sorted().count();
        System.out.println(count1);
        long end1 = System.currentTimeMillis();
        System.out.println("用时：" + (end1 - start1));

        System.out.println("");

        //并行流
        long start2 = System.currentTimeMillis();
        long count2 = list.parallelStream().sorted().count();
        System.out.println(count2);
        long end2 = System.currentTimeMillis();
        System.out.println("用时：" + (end2 - start2));
    }
}
