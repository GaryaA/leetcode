package org.example.leetcode.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestUniqSubstringTest {

    @Test
    void longestUniqSubstringTest() {
        LongestUniqSubstring obj = new LongestUniqSubstring();
        {
            String s = "qwuhsa";
            Assertions.assertEquals(6, obj.longestUniqSubstring(s));
        }
        {
            String s = "aadrecttt";
            Assertions.assertEquals(6, obj.longestUniqSubstring(s));
        }
        {
            String s = "aaaaaa";
            Assertions.assertEquals(1, obj.longestUniqSubstring(s));
        }
        {
            String s = "aaaaaabb";
            Assertions.assertEquals(2, obj.longestUniqSubstring(s));
        }
        {
            String s = "";
            Assertions.assertEquals(0, obj.longestUniqSubstring(s));
        }
    }

}