package com.zsmypb.springboot01.demo;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * zhang-shun
 *
 * @author zhangs.
 * @date 2020/3/27.
 */
public class MathDemo {
    public static void main(String[] args) {
        //probability(2);
        // /Users/zhangs/sql
//        fileList("/Users/zhangs/sql", 0);
        regex();
    }

    private static void regex() {
        String line = "This order was placed for QT3000! OK? zhang-shun";
        String pattern = "(\\D*)(\\d+)(.*)-([a-z]{1})";
        //创建Pattern对象
        Pattern p = Pattern.compile(pattern);
        //创建Matcher对象
        Matcher m = p.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("No Match!");
        }
        int n = m.groupCount();
        System.out.println(m.group(4).toUpperCase());
        System.out.println("一共有" + n + "个捕获组");
    }


    private static void fileList(String fileName, int count) {
        File file = new File(fileName);
        File[] files = file.listFiles();
        if (files == null) return;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                fileList(files[i].getName(), count);
            } else {
                count++;
                System.out.println("文件名字：" + files[i].getName());
            }
        }
        System.out.println("文件总数量：" + count);
    }

    public static void probability(int n) {
        int[] dice1 = {1, 2, 3, 4, 5, 6};

        Map<Integer, Integer> count = new HashMap();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int temp = dice1[i] + dice1[j];
                int value = count.getOrDefault(temp, -1);
                if (value == -1) {
                    count.put(temp, 1);
                } else {
                    count.put(temp, ++value);
                }
            }
        }
        count.forEach((integer, integer2) -> {
            System.out.println("和：" + integer + ", 概率: " + Math.pow(integer2.doubleValue(), n) / Math.pow(36, n));
        });
    }

}

class Main {

    public static void main(String[] args) {
        int N = 100;
        int[] array = new int[N];
        initData(array);

        Node[] count = new Node[50];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (count[array[i]] == null) count[array[i]] = new Node(array[i], 0);
                count[array[i]].count++;
            }
        }

        Arrays.sort(count, (o1, o2) -> {
            if (o1 == null || o2 == null) {
                if (o1 == null && o2 != null) return -1;
                else if (o1 != null && o2 == null) return 1;
                return 0;
            } else return o2.count - o1.count;
        });

        for (int i = 0; i < count.length; i++) {
            if (count[i] != null) {
                System.out.println(count[i].val + ", " + count[i].count);
            }
        }


    }

    static void initData(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + (int) (Math.random() * 49);
        }
    }

    static class Node {
        int val;
        int count;

        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

}
