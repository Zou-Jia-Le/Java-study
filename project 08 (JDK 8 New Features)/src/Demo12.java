import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Data、Instant 和 LocalDataTime 三类对象之间的转换
 */
public class Demo12 {
    public static void main(String[] args) {
        //1、Data ---> Instant
        Date date1 = new Date();
        System.out.println(date1);
        Instant instant1 = date1.toInstant();
        System.out.println(instant1.toString());
        System.out.println("");

        //2、Instant ---> LocalDataTime
        System.out.println(instant1);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
        System.out.println(localDateTime);
        System.out.println("");

        //3、LocalDataTime ---> Instant
        System.out.println(localDateTime);
        Instant instant2 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant2);
        System.out.println("");

        //4、Instant ---> Data
        System.out.println(instant2);
        Date date2 = Date.from(instant2);
        System.out.println(date2);
    }
}
