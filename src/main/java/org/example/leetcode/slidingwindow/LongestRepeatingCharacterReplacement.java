package org.example.leetcode.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] charsFrequencyArr = new int[26];
        int windowStart = 0;
        int windowEnd = 0;
        int maxCountInWindow = 0;
        for (; windowEnd < s.length(); ++windowEnd) {
            char ch = s.charAt(windowEnd);
            charsFrequencyArr[ch - 'A']++;
            maxCountInWindow = Math.max(maxCountInWindow, charsFrequencyArr[ch - 'A']);
            if (windowEnd - windowStart + 1 - maxCountInWindow > k) {
                charsFrequencyArr[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
        }
        return windowEnd - windowStart;
    }

}
