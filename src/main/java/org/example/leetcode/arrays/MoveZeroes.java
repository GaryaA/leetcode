package org.example.leetcode.arrays;

import org.example.leetcode.utils.Utils;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {

        int p = -1;
        int countZeroes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (countZeroes == 0) {
                    p = i;
                }
                countZeroes++;
                continue;
            }
            if (p != -1) {
                Utils.switchElems(nums, p, i);
                p = i - countZeroes + 1;
            }
        }

    }

}
