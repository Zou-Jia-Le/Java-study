import java.time.LocalDateTime;

/**
 * LocalDataTime 类
 */
public class Demo10 {
    public static void main(String[] args) {
        //创建本地时间对象
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 12, 31, 23, 59, 59);
        System.out.println(localDateTime2);
        System.out.println("");

        //打印 LocalDataTime 类对象的细节部分
        System.out.println(localDateTime2.getYear());
        System.out.println(localDateTime2.getMonthValue());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getHour());
        System.out.println(localDateTime2.getMinute());
        System.out.println(localDateTime2.getSecond());
        System.out.println("");

        //增加2天
        LocalDateTime plusDays = localDateTime2.plusDays(2);//LocalDataTime 类对象是不可变的，所以调用 plusDays 方法会返回一个新的 localDataTime 对象，而不是原来的 localDataTime2 （有点类似于字符串）
        System.out.println(plusDays);
        //减少1个月
        LocalDateTime minusMonths = localDateTime2.minusMonths(1);
        System.out.println(minusMonths);
    }
}
