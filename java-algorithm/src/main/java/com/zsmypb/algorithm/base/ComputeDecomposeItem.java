package com.zsmypb.algorithm.base;

import java.util.*;

/**
 * 找出这样的数字：一个数字等于它的各分解项相加。
 * 示例数字 28可分解为1、2、4、7、14，1+2+4+7+14=28。同样，数字6分解为:1、2、3，1+2+3=6。
 * 用代码找出1-500以内的所有符合这样条件的数字
 *
 * @author zhangs.
 * @date 2020/3/27.
 */
public class ComputeDecomposeItem {

    public static void main(String[] args) {
        System.out.println(splitInteger(28));
        int size = 500;
        for (int i = 1; i < size; i++) {
            Optional<Integer> reduce = splitInteger(i).stream().reduce((integer, integer2) -> integer + integer2);
            if (reduce.orElse(0) == i) {
                System.out.println(i);
            }
        }
    }

    static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    static List<Integer> splitInteger(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        HashSet<Pair> tempSet = new HashSet<>();
        int size = n / 2;
        for (int i = 2; i < size; i++) {
            int pair = n / i;
            if (pair * i == n) {
                tempSet.add(new Pair(i, pair));
            }
        }
        Iterator<Pair> iterator = tempSet.iterator();
        while (iterator.hasNext()) {
            Pair p = iterator.next();
            list.add(p.m);
            list.add(p.n);
        }
        return list;
    }

    static class Pair {
        int m;
        int n;

        Pair(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public int hashCode() {
            return m + n + m * n;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair p = (Pair) obj;
                return (m * n == p.m * p.n) && (m + n == p.m + p.n);
            } else {
                return false;
            }

        }
    }

}
