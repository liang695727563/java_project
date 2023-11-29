package com.example.w3cschool.testDemo;

// 位运算符
public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 60;
        int b = 13;
        int c = 0;
        System.out.println("二进制格式：");
        System.out.println("a = " + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b));
        c= a|b;
        System.out.println("c = " + Integer.toBinaryString(c));
        c = a&b;
        System.out.println("c = " + Integer.toBinaryString(c));
        c = a ^ b ;
        System.out.println("c = " + Integer.toBinaryString(c));
        System.out.println("******************************");
        // 以字符串的形式输出
        System.out.println(Integer.toString(a));
        // 以二进制的形式输出
        System.out.println(Integer.toBinaryString(a));
        // 以八进制的形式输出
        System.out.println(Integer.toOctalString(a));
        // 以16进制的形式输出
        System.out.println(Integer.toHexString(a));

//        原文链接：https://blog.csdn.net/Mylvzi/article/details/133863793/
    }
}
