package com.imooc.object_project.sample2;

public class PackageSample03 {
    //成员变量
    public String name;

    //成员方法
    private void sayHello() {
        System.out.println("Hello World!");
    }
    void sayGoodbye() {
        System.out.println("GoodBye!");
    }

    public static void main(String[] args) {
        //PackageSample01 packageSample01 = new PackageSample01();
        //PackageSample02 packageSample02 = new PackageSample02();

        PackageSample03 packageSample03 = new PackageSample03();
        packageSample03.sayHello();
        packageSample03.name = "不知道取什么名字比较好";
    }
}
