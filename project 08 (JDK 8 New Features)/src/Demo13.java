import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter 类的使用
 */
public class Demo13 {
    public static void main(String[] args) {
        //创建 DateTimeFormatter 类对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

        //1、把时间格式化成字符串
        String format = dtf.format(LocalDateTime.now());
        System.out.println(format);

        //2、把字符串解析成 LocalDateTime 类对象
        LocalDateTime localDateTime = LocalDateTime.parse("2020-03-10 10:20:35", dtf);
        System.out.println(localDateTime);
    }
}