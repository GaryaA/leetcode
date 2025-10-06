package org.example.leetcode.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecodeStringTest {

    private DecodeString obj = new DecodeString();

    @Test
    void decodeString() {
        Assertions.assertEquals("aaabcbc", obj.decodeString("3[a]2[bc]"));
    }

    @Test
    void decodeString1() {
        Assertions.assertEquals("accaccacc", obj.decodeString("3[a2[c]]"));
    }
}