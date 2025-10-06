package org.example.leetcode.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PowXNTest {

    private PowXN obj = new PowXN();

    @Test
    void myPow() {
        Assertions.assertEquals(1024d, obj.myPow(2d, 10));
    }

    @Test
    void myPow1() {
        Assertions.assertEquals(9.261d, obj.myPow(2.1d, 3));
    }

    @Test
    void myPow2() {
        Assertions.assertEquals(0.25d, obj.myPow(2d, -2));
    }

    @Test
    void myPow4() {
        Assertions.assertEquals(0.25d, obj.myPow(2d, -2));
    }

    @Test
    void myPow5() {
        Assertions.assertEquals(0d, obj.myPow(2.00d, -200000000));
    }

    @Test
    void myPow6() {
        Assertions.assertEquals(0d, obj.myPow(0.00001d, 2147483647));
    }

    @Test
    void myPow7() {
        Assertions.assertEquals(0.00003d, obj.myPow(3.76050d, -8));
    }

    @Test
    void myPow8() {
        Assertions.assertEquals(0d, obj.myPow(2d, -2147483648));
    }

}