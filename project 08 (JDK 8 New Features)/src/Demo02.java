/**
 * Lambda 表达式
 */
public class Demo02 {
    //静态方法
    public static void run(Usb usb) {
        usb.service();
    }

    public static void main(String[] args) {
        //匿名内部类
        Usb mouse = new Usb() {
            @Override
            public void service() {
                System.out.println("鼠标开始工作了......");
            }
        };
        run(mouse);

        //Lambda 表达式
        //函数式接口可以使用 Lambda 表达式，Lambda 表达式会被匹配到唯一的抽象方法上
        Usb fan = () -> System.out.println("风扇开始工作了......");
        run(fan);
    }
}


