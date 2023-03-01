package com.example.demo.test_1;

import java.text.NumberFormat;

/**
 * 实现保留两位小数
 */
public class Test01 {
    public static void main(String[] args) {
        extracted();
        extracted1();
    }

    //    方法一：NumberFormat方法
    private static void extracted() {
        int a = 1, b = 3;
        double sum = (double) a / b;
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2); //要是保留两位小数
        System.out.println(" sum = " + nt.format(sum));
//        System.out.println(" sum = " + nt.format(0));
    }

    // 方法二：Math.round()
    private static void extracted1() {
        int a = 2, b = 3;
        double sum2 = (double) a / b;
        System.out.println("sum2 = " + Math.round(sum2 * 100)+"%");
    }
}
