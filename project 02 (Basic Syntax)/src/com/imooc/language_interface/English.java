package com.imooc.language_interface;

public class English implements Language{
    //方法实现
    @Override
    public void voice(){
        System.out.println("May i help you ?");
    }
}
