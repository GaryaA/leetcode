package org.example.leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqSubstring {

    public int longestUniqSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) return s.length();

        int left = 0;
        int right = 1;
        int maxUniqSubstring = 1;

        Map<Character, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(s.charAt(left), true);

        while (left < s.length() - 1) {

            if (!visitedMap.getOrDefault(s.charAt(right), false)) {
                visitedMap.put(s.charAt(right), true);
                if (right - left + 1 > maxUniqSubstring) {
                    maxUniqSubstring = right - left + 1;
                }
                if (right < s.length() - 1) {
                    right++;
                } else {
                    left++;
                    right = left + 1;
                }
            } else {
                visitedMap.put(s.charAt(left), false);
                left++;
            }

        }
        return maxUniqSubstring;
    }

}
