package org.example.leetcode.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PowerofFourTest {

    private PowerofFour obj = new PowerofFour();

    @Test
    void isPowerOfFour() {
        Assertions.assertTrue(obj.isPowerOfFour(16));
    }

    @Test
    void isPowerOfFour1() {
        Assertions.assertFalse(obj.isPowerOfFour(5));
    }

    @Test
    void isPowerOfFour2() {
        Assertions.assertTrue(obj.isPowerOfFour(1));
    }

    @Test
    void isPowerOfFour3() {
        Assertions.assertFalse(obj.isPowerOfFour(0));
    }

}