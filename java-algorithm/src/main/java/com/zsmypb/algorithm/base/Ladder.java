package com.zsmypb.algorithm.base;

/**
 * @author zhangs.
 * @date 2020/4/10.
 */
public class Ladder {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climb_Stairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climb_Stairs(int n) {
        int r = 0;
        int t = 1;
        int t1;
        for (int j = 1; j <= n; j++) {
            if (j == 1) {
                r = 1;
                continue;
            }
            if (j == 2) {
                r = 2;
                continue;
            }
            t1 = r;
            r = r + t;
            t = t1;
        }
        return r;
    }
}
