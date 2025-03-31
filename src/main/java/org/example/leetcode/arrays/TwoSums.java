package org.example.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                r[0] = map.get(target - nums[i]);
                r[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return r;
    }

}
