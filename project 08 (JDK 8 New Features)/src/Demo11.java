import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Set;

/**
 * Instant 时间戳
 * ZoneId 时区
 */
public class Demo11 {
    public static void main(String[] args) {
        //创建 Instant 时间戳
        Instant instant1 = Instant.now();//打印的时间比我们慢 8 小时，因为我们在东八区
        System.out.println(instant1.toString());
        Instant instant2 = Instant.ofEpochMilli(instant1.toEpochMilli());//用毫秒数指定时间戳对象
        System.out.println(instant2.toString());
        System.out.println("");

        //打印从 1970年1月1日0时0分0秒 至今的毫秒数
        System.out.println(instant1.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        //程序执行有延迟，一定不会完全相等，但误差很小
        System.out.println("");

        //增减时间
        Instant instant3 = instant1.plusSeconds(10);//增加 10 秒
        System.out.println(Duration.between(instant1, instant3).toMillis());//打印 instant1 和 instant3 相差的毫秒数
        Instant instant4 = instant1.minusSeconds(10);//减少 10 秒
        System.out.println(Duration.between(instant4, instant1).toMillis());//打印 instant4 和 instant3 相差的毫秒数
        System.out.println("");

        //ZoneId 时区
//        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();//获取当前系统可支持的时区
//        for (String zoneId : availableZoneIds) {//遍历所有的时区
//            System.out.println(zoneId);
//        }
//        System.out.println("=============");
        System.out.println(ZoneId.systemDefault().toString());//打印当前系统的时区
    }
}
