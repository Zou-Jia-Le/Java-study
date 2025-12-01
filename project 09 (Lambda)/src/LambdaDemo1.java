/**
 * 目标：认识 Lambda 表达式，搞清楚其写法和使用前提
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程 1 执行了......");
            }
        }).start();

        //Lambda 表达式
        new Thread(() -> System.out.println("新线程 2 执行了......")).start();
    }
}
