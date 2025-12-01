package com.imooc.language_interface;

public class Chinese implements Language {
    //方法实现
    @Override
    public void voice() {
        System.out.println("您好，请问有什么可以为你服务的？");
    }
}
