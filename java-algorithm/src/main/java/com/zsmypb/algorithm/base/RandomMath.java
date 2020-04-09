package com.zsmypb.algorithm.base;

import java.util.Arrays;

/**
 * 长度为N的数组，随机放入值为1-50中间的任意整数，请编写程序找出其中的偶数数字，并按照该数字在数组中出现次数从多到少排序输出。
 * @author zhangs.
 * @date 2020/4/2.
 */
public class RandomMath {
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
