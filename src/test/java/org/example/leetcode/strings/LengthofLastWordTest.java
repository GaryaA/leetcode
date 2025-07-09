package org.example.leetcode.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LengthofLastWordTest {

    @Test
    public void lengthOfLastWordTest() {
        String s = " fly   moon  ";
        int lS = new LengthofLastWord().lengthOfLastWord(s);
        Assertions.assertEquals(4, lS);
    }

}
