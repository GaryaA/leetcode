package org.example.leetcode.twopointers;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Quadruple> r = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (
                        int k = j + 1,
                        left = k,
                        right = nums.length - 1;

                        left < right && k < nums.length;

                        k++
                ) {
                    if ((long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right] == (long) target) {
                        r.add(new Quadruple(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if ((long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right] < (long) target) {
                        left++;
                    } else if ((long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right] > (long) target) {
                        right--;
                    }
                }
            }
        }

        return r.stream().map(qu -> {
            List<Integer> l = new ArrayList<>();
            l.add(qu.a());
            l.add(qu.b());
            l.add(qu.c());
            l.add(qu.d());
            return l;
        }).toList();
    }


    public record Quadruple(int a, int b, int c, int d) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Quadruple quadruple)) return false;
            int[] arr = {a, b, c, d};
            Arrays.sort(arr);
            int[] arrO = {quadruple.a, quadruple.b, quadruple.c, quadruple.d};
            Arrays.sort(arrO);
            return Arrays.equals(arr, arrO);
        }

        @Override
        public int hashCode() {
            return hashCode(a, b, c, d);
        }

        public static int hashCode(int a, int b, int c, int d) {
            int[] arr = {a, b, c, d};
            Arrays.sort(arr);
            return Arrays.hashCode(arr);
        }

        @Override
        public String toString() {
            return "[" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    ", d=" + d +
                    ']';
        }
    }

}
