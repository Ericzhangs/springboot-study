package com.zsmypb.springboot01.demo;

/**
 * @author zhangs.
 * @date 2020/3/19.
 */
public class Demo {
    public static void main(String[] args) {
//        Integer i1 = new Integer(10);
//        int i2 = 10;
//        System.out.println(i1 == i2);
//        Integer i3 = new Integer(129);
//        int i4 = 129;
//        System.out.println(i3 == i4);
//        Integer i5 = 128;
//        Integer i6 = 128;
//        System.out.println(i5 == i6);
//        Integer i7 = 10;
//        Integer i8 = 10;
//        System.out.println(i7 == i8);
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
