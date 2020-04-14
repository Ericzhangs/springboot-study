package com.zsmypb.springboot02.base;

import com.google.common.base.Splitter;

/**
 * @author zhangs.
 * @date 2020/4/11.
 */
public class Dome1 {
    public static void main(String[] args) {
        String s = "a-b-";
        Iterable<String> split = Splitter.on("-").split(s);
        System.out.println(split);
    }
}
