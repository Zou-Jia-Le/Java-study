package com.java;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        int classNUM=3;
        int stuNUM=4;
        int sum=0;
        double avg=0;
        for(int i =1;i<=classNUM;i++){
            System.out.println("***请输入第"+i+"个班级的成绩***");
            sum=0;
            for(int j=1;j<=stuNUM;j++){
                System.out.print("请输入第"+j+"个学生的成绩：");
                int score = new Scanner(System.in).nextInt();
                //System.out.println("学生成绩："+score);
                sum+=score;
            }
            avg=sum/stuNUM;
            System.out.println("第"+i+"个班级学生的平均成绩为："+avg);
        }
    }
}
