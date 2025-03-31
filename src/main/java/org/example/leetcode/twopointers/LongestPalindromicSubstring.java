package org.example.leetcode.twopointers;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) return s;
        int left = 0, right = s.length() - 1;
        int longestPalindromeSize = 0;
        int rLeft = 0, rRight = 0;
        for (; right > left; right--) {
            if (s.charAt(right) != s.charAt(left)) {
                if (right - left == 1) {
                    left++;
                    right = s.length();
                }
                continue;
            }
            if (isPalindrome(s, left, right)) {
                if (longestPalindromeSize < right - left + 1) {
                    longestPalindromeSize = right - left + 1;
                    rLeft = left;
                    rRight = right;
                }
                left++;
                right = s.length();
            }
        }
        return s.substring(rLeft, rRight + 1);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
