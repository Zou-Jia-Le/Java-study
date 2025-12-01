package com.imooc.object_project.sample6;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSample {
    public static void main(String[] args) {
        //集合
        List<String> bookList = new ArrayList<String>();//泛型
        bookList.add("红楼梦");
        bookList.add("西游记");
        bookList.add("水浒传");
        bookList.add("三国演义");
        bookList.add(0,"镜花缘");//指定位置
        System.out.println(bookList);
        //bookList.add(0);
        System.out.println("");

        //获取元素
        String bookname = bookList.get(2);
        System.out.println(bookname);
        System.out.println("");

        //集合大小
        int size = bookList.size();
        System.out.println(size);
        System.out.println("");

        //移除元素
        bookList.remove(2);
        System.out.println(bookList);
        bookList.remove(bookList.size() - 1);
        System.out.println(bookList);
        System.out.println("");

        //遍历
        for(String book: bookList){
            System.out.println("《"+book+"》");
        }
    }
}
