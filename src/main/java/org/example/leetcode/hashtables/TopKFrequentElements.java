package org.example.leetcode.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;

        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) {
            dict.put(num, dict.getOrDefault(num, 0) + 1);
        }
        return dict.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

}
