import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //--------------------------------------------------------------------------------------------------------------
        //创建 Optional 类对象
        String value1 = "Albert";
        //Optional<String> optionalBox = Optional.empty();//创建一个空的 Optional<String> 容器
        //Optional<String> optionalBox = Optional.of(value1);//value1 如果为 null 会抛出 NullPointerException 异常类对象
        Optional<String> optionalBox = Optional.ofNullable(value1);//value1 可以为空，也能不为空

        //判断 Optional 类对象是否为空
        System.out.println(optionalBox.isPresent());//判断是否为空，不空为 true， 空为 false
//        System.out.println(optionalBox.isEmpty);//JDK 11 引入

        //获取 Optional 类对象
        String value2 = optionalBox.get();
        System.out.println(value2);
        System.out.println("");

        //--------------------------------------------------------------------------------------------------------------

        //传统方式：
        //1、不用 Optional 类
//        UserRepository userRepository = new UserRepository();
//        User user1 = userRepository.findUserByName("Albert2");
//        if (user1 != null) {
//            System.out.println(user1.getFullname());
//        } else {
//            User defaultUser = new User("Neo","Thomas Anderson");//没有 Albert2，应该打印 Thomas Anderson
//            System.out.println(defaultUser.getFullname());
//        }

        //2、用 Optional 类，但是仍用传统方式提取对象
//        UserRepository userRepository = new UserRepository();
//        Optional<User> user2 = userRepository.findUserByName("Albert2");
//        if (user2.isPresent()) {
//            System.out.println(user2.get().getFullname());
//        } else {
//            User defaultUser = new User("Neo", "Thomas Anderson");//没有 Albert2，应该打印 Thomas Anderson
//            System.out.println(defaultUser.getFullname());
//        }

        //--------------------------------------------------------------------------------------------------------------

        //Optional 方式：
        UserRepository userRepository = new UserRepository();
        Optional<User> user3 = userRepository.findUserByName("Albert2");

        //==============================================================================================================

        //返回另一个对象结果
        User user4 = user3.orElse(new User("Neo", "Thomas Anderson"));//没有 Albert2，应该打印 Thomas Anderson
        System.out.println(user4.getFullname1());
        //或（区别是 orElse() 不管 Optional 内的对象是否为空，都执行内部的语句；而 orElseGet () 只有在 Optional 内的对象为空时，才会执行内部的语句；所以当确定对象不为空是用 orElse()，否则用 orElseGet ()）
        User user5 = user3.orElseGet(() -> new User("Neo", "Thomas Anderson"));//没有 Albert2，应该打印 Thomas Anderson
        System.out.println(user5.getFullname1 ());

        //==============================================================================================================

        //抛出异常对象
        //User user6 = user3.orElseThrow(() -> new RuntimeException("User not found"));//没有 Albert2，应该抛出 RuntimeException 异常类对象

        //==============================================================================================================

        //判断对象是否为空对象
        //如果对象为空对象，那么 ifPresent 将执行内部语句，否则将什么都不会做
        user3.ifPresent(user -> System.out.println(user.getFullname1()));
        //如果对象为空对象，那么 ifPresentOrElse 将执行内部语句，否则将执行其它语句(JDK 9 引入)
//        user3.ifPresentOrElse(
//                user -> System.out.println(user.getFullname()),
//                () -> System.out.println("User not found")
//        );

        //==============================================================================================================

        //判断 Optional 对象是否满足条件
        //满足条件返回一个新的 Optional 对象，否则返回一个空的 Optional 对象
        Optional<User> user7 = user3.filter(user -> user.getName().equals("Albert2"));
        System.out.println(user7.isPresent());

        //==============================================================================================================

        //对 Optional 中的对象进行转换
        //如果 Optional 对象为空，那么 map() 方法会返回一个空的 Optional 对象；如果不为空，那么会将执行结果包装到另一个 Optional 对象中，并将其返回
        Optional<String> user8 = user3.map(User::getFullname1);
        user8.ifPresent(user -> System.out.println("执行结果：" + user8.get()));

        //==============================================================================================================

        //处理嵌套
        //使用 map 处理返回 Optional 类对象的方法会产生嵌套
        Optional<Optional<String>> user9 = user3.map(User::getFullname2);//这里的类型是 Optional<Optional<String>>
        //使用 flatMap 处理返回 Optional 类对象的方法会展平嵌套
        Optional<String> user10 = user3.flatMap(User::getFullname2);//这里的类型是 Optional<String>

        //==============================================================================================================

        //将 Optional 类对象转换为流，进行流处理
//        Stream<String> a = user3.map(User::getName)
//                .steam();//转换为流（JDK 9 引入）
//        a.forEach(System.out::println);
        //----------------------------------------------------------------------------------------------------------
    }
}

//Optional 类的主要作用：当我们设计一个 API 时，Optional 的主要作用是引导 API 的使用者，告诉它们我们这个结果可能不存在，并强制调用者处理这种可能性，可以减少错误的发生

/*不适合使用 Optional 的场景：
1、使用 Optional 作为字段类型会增加内存消耗，并且会使得对象的序列化变得复杂
2、Optional 也不适合作为构造/成员方法形参的类型，会使方法的使用和理解变得复杂（方法重载更适合处理：可能方法形参为空的情况）
3、Optional 也不适合作为集合的类型（集合有更好的处理空集合的方法，例如：if(集合 == null) {return Collections.emptyList()} else {return 集合}
4、调用 Optional 类的 get() 方法之前没有确认值是否会存在，可能会导致 NoSuchElementException 异常，即使是使用 isPresent 和 get 的组合也不是一个好的选择，因为这样做和直接调用可能为 null 没区别（详见 "正确处理 Optional 对象可能为空的情况.png"）*/
