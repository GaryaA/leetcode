package org.example.leetcode.math;

public class ClimbingStairs {

    /*
        Example 1:
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

        Example 2:
        Input: n = 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

        Example 3:
        Input: n = 4
        1. 1 + 1 + 1 + 1
        2. 1 + 1 + 2
        3. 1 + 2 + 1
        4. 2 + 1 + 1
        5. 2 + 2
        Output: 5

        Example 4:
        Input: n = 5
        1. 1 + 1 + 1 + 1 + 1
        2. 1 + 1 + 1 + 2
        3. 1 + 1 + 2 + 1
        4. 1 + 2 + 1 + 1
        5. 2 + 1 + 1 + 1
        6. 1 + 2 + 2
        7. 2 + 2 + 1
        8. 2 + 1 + 2
        Output: 8
     */

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int step1 = 1;
        int step2 = 2;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i = 3; i <= n; i++) {
            int tmp = step2;
            step2 = step1 + step2;
            step1 = tmp;
        }
        return step2;
    }

}
