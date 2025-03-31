package org.example.leetcode.arrays;

import java.util.Arrays;
import java.util.Stack;

public class SquaresofaSortedArray {

    public static void main(String[] args) {

        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int left = 0; left < arr.length; ) {
            if (arr[left] < 0) {
                stack.push(arr[left++]);
                continue;
            }
            if (stack.isEmpty()) {
                arr[j++] = arr[left] * arr[left];
                left++;
            } else {
                int value;
                if (Math.abs(stack.peek()) <= arr[left]) {
                    value = stack.pop();
                } else {
                    value = arr[left++];
                }
                arr[j++] = value * value;
            }
        }
        while (!stack.isEmpty()) {
            int value = stack.pop();
            arr[j++] = value * value;
        }
        return arr;
    }

}
