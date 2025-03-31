package org.example.leetcode.strings;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return funcRecursion(s, 0);
    }

    public static int funcRecursion(String s, int len) {
        if (s.isEmpty()) {
            return 0;
        }
        Stack<Holder> stack = new Stack<>();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(new Holder(ch, i));
                continue;
            }
            if (stack.isEmpty()) {
                continue;
            }
            Holder peekChar = stack.peek();
            if (ch == ')' && peekChar.ch != '(') {

            } else {
                arr[stack.pop().idx] = 1;
                arr[i] = 1;
            }
        }

        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
                continue;
            }
            if (arr[i] == 1) {
                count++;
                if (count > maxLen) {
                    maxLen = count;
                }
            }
        }
        return maxLen;
    }

    public static class Holder {
        char ch;
        int idx;

        public Holder(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

}
