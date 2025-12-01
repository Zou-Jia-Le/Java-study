package com.imooc.language_interface;

import java.util.Scanner;

public class CustomerService {
    //成员方法
    public Language contact(int num){
        if(num == 1){
            return new Chinese();
        }else if (num == 2) {
            return new Franch();
        }else {
            return new English();
        }
    }

    public static void main(String[] args) {
        Language language1 = new Chinese();
        language1.voice();
        Language language2 = new English();
        language2.voice();
        Language language3 = new Franch();
        language3.voice();

        System.out.println("=================================================");

        CustomerService customerService = new CustomerService();
        Language language4 = customerService.contact(1);
        language4.voice();
        //System.out.println(language4);
        Language language5 = customerService.contact(2);
        language5.voice();
        //System.out.println(language5);
        Language language6 = customerService.contact(3);
        language6.voice();
        //System.out.println(language6);

        System.out.println("=================================================");

        System.out.print("请输入1-3来选择你要输出的内容：1.中文  2.法语  3.英语 : ");
        Scanner input  = new Scanner(System.in);
        int a = input.nextInt();
        Language language7 = customerService.contact(a);
        language7.voice();
        //System.out.println(language7);
    }
}
