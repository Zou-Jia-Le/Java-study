//import java.text.SimpleDateFormat;//导入 SimpleDateFormat 类，用于日期格式化和解析（注意：该类是非线程安全的）
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;//导入 Callable 接口，用于创建可返回结果的任务
import java.util.concurrent.ExecutorService;//导入 ExecutorService 接口，用于管理线程池
import java.util.concurrent.Executors;//导入 Executors 工具类，用于创建线程池
import java.util.concurrent.Future;//导入 Future 接口，用于表示异步计算的结果

/**
 * 线程安全问题演示类
 * 本程序演示了 SimpleDateFormat 在多线程环境下的线程安全问题
 */
public class Demo09 {
    public static void main(String[] args) throws Exception {
        //创建 SimpleDateFormat 对象，指定日期格式为 "年-月-日"
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //创建固定大小的线程池，包含 10 个线程（线程池可以重用线程，避免频繁创建和销毁线程的开销）
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //创建 Callable 任务，该任务可以返回结果并抛出异常（Callable 通常用于需要返回值的异步任务）
        Callable<LocalDate> callable = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("2020-04-25",dtf);
            }
        };

        //创建 Future 列表，用于保存所有异步任务的执行结果（Future 代表一个异步计算的结果，可以通过它获取任务执行状态和结果）
        List<Future<LocalDate>> list = new ArrayList<>();
        //将 Callable 任务提交给线程池执行（submit 方法立即返回一个 Future 对象，不会阻塞当前线程）
        for (int i = 0; i < 10; i++) {
            Future<LocalDate> future = pool.submit(callable);
            list.add(future);
        }

        //遍历 Future 列表，获取每个任务的执行结果
        for (Future<LocalDate> future : list) {
            System.out.println(future.get());//如果任务成功完成，返回计算结果（LocalDate 对象）；如果任务执行过程中抛出异常，get() 会抛出 ExecutionException
        }

        //关闭线程池
        pool.shutdown();
    }
}