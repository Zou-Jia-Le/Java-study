public class Dog {
    //成员变量
    String name;
    int age;
    float weight;

    public static void main(String[] args) {
        Dog duoduo = new Dog();
        duoduo.name = "多多";
        duoduo.age = 6;
        duoduo.weight = 13.5f;

        Dog lucky = new Dog();
        lucky.name = "Lucky";
        lucky.age = 3;
        lucky.weight = 10.2f;

        //Dog petDog = new Dog();

        System.out.println(duoduo.name + "今天 "+duoduo.age + " 岁了");
        System.out.println(lucky.name + " 体重 "+lucky.weight + " 千克");
    }
}
