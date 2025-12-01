package com.imooc.chinese_zodiac;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //增加元素
        list.add("鼠");
        list.add("牛");
        list.add("虎");
        list.add("兔");
        list.add("龙");
        list.add("蛇");
        list.add("马");
        list.add("羊");
        list.add("猴");
        list.add("鸡");
        list.add("狗");
        list.add("猪");
        System.out.println(list);

        //增添元素
        list.add(0,"生肖");
        System.out.println(list);

        //获取指定位置元素
        String shengxiao = list.get(5);
        System.out.println(shengxiao);

        //集合大小
        int size = list.size();
        System.out.println(size);

        //移除元素
        list.remove(0);
        System.out.println(list);

        list.add("结束语");
        System.out.println(list);
        list.remove(list.size() - 1);
        System.out.println(list);

        //遍历集合
        for(String animal:list){
            System.out.print("《"+animal+"》");
        }
    }
}
