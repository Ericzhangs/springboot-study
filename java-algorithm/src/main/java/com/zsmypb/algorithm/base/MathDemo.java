package com.zsmypb.algorithm.base;

import java.io.File;
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
//        String text = "main-action-holder-shun";
//        text.replaceAll("-([a-z]{1})", "$1");
//        text.replace("^(.*)$", "\\U\\1");
//        System.out.println(text);
        regex("main-action-holder-shun");
    }

    /**
     * 将字符串main-action-holder，转换为mainActionHolde
     */
    private static void regex(String text) {
        String line = text;
        String pattern = "(-[a-z]{1})";
        //创建Pattern对象
        Pattern p = Pattern.compile(pattern);
        //创建Matcher对象
        Matcher m = p.matcher(line);
        System.out.println("1111" + m.matches());
        System.out.println("Found value: " + m.groupCount());
        System.out.println("Found value: " + m.find());
//        System.out.println("Found value: " + m.group(1));

        for (int i = 1; i <= m.groupCount(); i++) {
            System.out.println("Found value: " + m.group(i));
        }
//        if (m.find()) {
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2));
//            System.out.println("Found value: " + m.group(3));
//        } else {
//            System.out.println("No Match!");
//        }
        int n = m.groupCount();
//        System.out.println(m.group(4).toUpperCase());
        System.out.println("一共有" + n + "个捕获组");
    }

    /**
     * 列出一个目录下所有的文件，包括所有子目录下的文件，并打印出文件总数
     */
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

    /**
     * 同时投掷2颗6面骰子n次，计算其和得到各数字的概率
     *
     * @param n
     */
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
