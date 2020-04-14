package com.zsmypb.springboot01.car;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangs.
 * @date 2020/4/13.
 */
public class TestMian {
    public static void main(String[] args) {
        String s1 = "奥迪 奥迪Q5 2018款 奥迪Q5 典藏版 40 TFSI 技术型";
        List<String> strings = Arrays.asList(s1.split(" "));
        System.out.println(strings);
        System.out.println(strings.stream().distinct().collect(Collectors.toList()));
        List list = removeDuplicationByHashSet(strings);
        System.out.println(list);
    }

    public static List removeDuplicationByHashSet(List<String> list) {
        TreeSet set = new TreeSet(list);
        //把List集合所有元素清空
        ArrayList list1 = new ArrayList();
        //把HashSet对象添加至List集合
        list1.addAll(set);
        return list1;
    }
}
