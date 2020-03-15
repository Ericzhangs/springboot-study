package com.zsmypb.springboot01.vo;

/**
 * @author zhangs.
 * @date 2020/3/15.
 */
public class Book {
    private String name;

    public Book(String mes) {
        System.out.println(mes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
